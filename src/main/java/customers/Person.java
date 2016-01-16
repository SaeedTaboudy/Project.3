package customers;

import java.math.BigInteger;

/**
 * @author Saeed Taboudy
 */
public class Person extends BaseInformation {
    private BigInteger nationalCode;
    private String firstName;
    private String LastName;
    private String fatherName;
    private String birthday;

    public Person() {
    }

    public Person(BigInteger nationalCode, String firstName, String lastName, String fatherName, String birthday) {
        this.nationalCode = nationalCode;
        this.firstName = firstName;
        LastName = lastName;
        this.fatherName = fatherName;
        this.birthday = birthday;
    }

    public BigInteger getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(BigInteger nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nationalCode=" + nationalCode +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

}
