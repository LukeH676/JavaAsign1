package model;

/**
 *
 * @author Luke
 */
public class TripType {

    private int tripTypeId;
    private String tripName;
    private String description;

    /**
     *
     */
    public TripType() {
        tripTypeId = 0;
        tripName = "";
        description = "";
    }

    /**
     *
     * @return
     */
    public int getTripTypeId() {
        return tripTypeId;
    }

    /**
     *
     * @return
     */
    public String getTripName() {
        return tripName;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param tripTypeId
     */
    public void setTripTypeId(int tripTypeId) {
        this.tripTypeId = tripTypeId;
    }

    /**
     *
     * @param name
     */
    public void setTripName(String name) {
        this.tripName = name;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return tripTypeId + "," + tripName + "," + description;
    }
}
