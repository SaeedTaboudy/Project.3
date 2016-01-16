package customers;

/**
 * @author Maral Khojasteh
 */
public class Company extends BaseInformation {
    private long economicCode;
    private String name;
    private String registrationDate;

    public Company(long economicCode, String name, String registrationDate) {
        this.economicCode = economicCode;
        this.name = name;
        this.registrationDate = registrationDate;
    }

    public Company() {
    }

    public long getEconomicCode() {
        return economicCode;
    }

    public void setEconomicCode(long economicCode) {
        this.economicCode = economicCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "economicCode=" + economicCode +
                ", name='" + name + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
