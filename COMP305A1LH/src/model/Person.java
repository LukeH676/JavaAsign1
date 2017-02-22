package model;

/**
 *
 * @author Luke
 */
public class Person {

    private int personId;
    private String name;
    private String jobTitle;
    private boolean frequentFlyer;

    /**
     *
     */
    public void Person() {
        personId = 99;
        name = "test";
        jobTitle = "testj";
        frequentFlyer = false;

    }

    /**
     *
     * @param personId
     */
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param jobTitle1
     */
    public void setJobTitle(String jobTitle1) {
        this.jobTitle = jobTitle1;
    }

    /**
     *
     * @param frequentFlyer
     */
    public void setFrequentFlyer(Boolean frequentFlyer) {
        this.frequentFlyer = frequentFlyer;
    }

    @Override
    public String toString() {
        return personId + "," + name + "," + jobTitle + "," + this.getFrequentFlyer();
    }

    /**
     *
     * @return
     */
    public int getPersonId() {
        return this.personId;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return
     */
    public String getJobTitle() {
        return this.jobTitle;
    }

    /**
     *
     * @return
     */
    public String getFrequentFlyer() {
        return (this.frequentFlyer) ? "Yes" : "No";
    }

}
