package model;

;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Luke
 */


public class Trip {

    int tripId;
    Person personRef;
    Date depdate;
    String depCity;
    String destCity;
    TripType triptypeRef;
    SimpleDateFormat myFormat = new SimpleDateFormat("MMMM-d-yyyy", Locale.ENGLISH);

    /**
     * Constructor
     */
    public Trip() {
        this.tripId = 0;
        this.personRef = personRef;
        this.depdate = depdate;
        this.depCity = depCity;
        this.destCity = destCity;
        this.triptypeRef = triptypeRef;
    }

    /**
     *
     * @return
     */
    public int getTripId() {
        return tripId;
    }

    /**
     *
     * @return
     */
    public Person getPersonRef() {
        return personRef;
    }

    /**
     *
     * @return
     */
    public Date getDepdate() {
        return depdate;
    }

    /**
     *
     * @return
     */
    public String getDepCity() {
        return depCity;
    }

    /**
     *
     * @return
     */
    public String getDestCity() {
        return destCity;
    }

    /**
     *
     * @return
     */
    public TripType getTriptypeRef() {
        return triptypeRef;
    }

    /**
     *
     * @param tripId
     */
    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    /**
     *
     * @param personRef
     */
    public void setPersonRef(Person personRef) {
        this.personRef = personRef;
    }

    /**
     *
     * @param depdate
     */
    public void setDepDate(Date depdate) {
        this.depdate = depdate;
    }

    /**
     *
     * @param depCity
     */
    public void setDepCity(String depCity) {
        this.depCity = depCity;
    }

    /**
     *
     * @param destCity
     */
    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    /**
     *
     * @param triptypeRef
     */
    public void setTripTypeRef(TripType triptypeRef) {
        this.triptypeRef = triptypeRef;
    }

    @Override
    public String toString() {
        return tripId + "," + personRef + "," + myFormat.format(depdate) + "," + depCity + "," + destCity + "," + triptypeRef;
    }

}
