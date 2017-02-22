
/**
 *
 * @author Luke Hahn
 * Assignment #1 Java
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import model.Person;
import model.Trip;
import model.TripType;

/**
 *
 * @author Luke
 */
public class Main {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";
    private static final String CONN_STRING
            = "jdbc:mysql://localhost/travel";

    /**
     *
     * @param args
     * @throws SQLException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        BufferedWriter out = null;

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            FileWriter fstream = new FileWriter("src//HTML//table.html");
            out = new BufferedWriter(fstream);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM person");
            System.out.println("connected");
            ArrayList<Person> newList = new ArrayList<>();
            HashMap<Integer, Person> personMap = new HashMap<>();

            while (rs.next()) {
                Person newPerson = new Person();
                newPerson.setPersonId(rs.getInt("personid"));
                newPerson.setName(rs.getString("name"));
                newPerson.setJobTitle(rs.getString("jobTitle"));
                newPerson.setFrequentFlyer(rs.getBoolean("frequentflyer"));
                newList.add(newPerson);
            }

            for (Person person : newList) {
                personMap.put(person.getPersonId(), person);
            }
            System.out.println(personMap);
            System.out.println("----- NEXT -----");

            rs = stmt.executeQuery("SELECT * FROM tripType");
            HashMap<Integer, TripType> tripTypeMap = new HashMap<>();

            while (rs.next()) {
                TripType newTripType = new TripType();
                newTripType.setTripTypeId(rs.getInt("triptypeid"));
                newTripType.setTripName(rs.getString("name"));
                newTripType.setDescription(rs.getString("description"));
                tripTypeMap.put(newTripType.getTripTypeId(), newTripType);
            }
            System.out.println(tripTypeMap);
            System.out.println("----- NEXT -----");

            rs = stmt.executeQuery("SELECT * FROM trip");
            ArrayList<Trip> newTripList = new ArrayList<>();
            Trip newTrip;

            while (rs.next()) {

                newTrip = new Trip();
                newTrip.setPersonRef(personMap.get(rs.getInt("personid")));
                newTrip.setTripTypeRef(tripTypeMap.get(rs.getInt("triptypeid")));
                newTrip.setTripId(rs.getInt("tripid"));
                newTrip.setDepDate(rs.getDate("depdate"));
                newTrip.setDepCity(rs.getString("depcity"));
                newTrip.setDestCity(rs.getString("destcity"));
                newTripList.add(newTrip);

            }

            for (Trip trip : newTripList) {
                System.out.println(trip);
            }
            out.write("<html>");
            out.write("<head>");
            out.write("<title>COMP305A1HAHN</title>");
            out.write("</head>");
            out.write("<body>");
            out.write("<table border=\"1\">");
            out.write("<tr>");
            out.write("<th> Trip ID </th> <th> PersonID</th><th> Last Name</th><th>First Name</th>"
                    + "<th>Job Title</th><th>FF</th><th>Dep Date</th><th>Dep City</th><th>Dest City</th>"
                    + "<th>TripTypeID</th><th>Type Name</th><th>Description</th>");
            out.write("<tr>");
            for (Trip trip : newTripList) {
                out.write("<tr>");
                String[] myStringArray = trip.toString().split(",");
                for (String myString : myStringArray) {
                    out.write("<td>" + myString + "</td>");
                }
                out.write("</tr>");
            }
            out.write("</table>");
            out.write("</body>");
            out.write("</html>");

        } catch (SQLException e) {

            System.err.println(e);

        } finally {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }
}
