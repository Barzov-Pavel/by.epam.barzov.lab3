package domain;

public class Certificate {
    private int id;
    private String startDate;
    private String expirationDate;
    private String registrationOrganization;

    public Certificate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getRegistrationOrganization() {
        return registrationOrganization;
    }

    public void setRegistrationOrganization(String registrationOrganization) {
        this.registrationOrganization = registrationOrganization;
    }
}
