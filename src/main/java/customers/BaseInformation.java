package customers;

/**
 * @author Saeed taboudy
 */
public abstract class  BaseInformation {
    public long customerNumber;

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }
}
