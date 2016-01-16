package exception;

/**
 * @author Saeed Taboudy  1/16/2016
 */
public class RepetitiousNationalCode extends Exception {
    private String message = null;

    public RepetitiousNationalCode() {
    }

    @Override
    public String toString() {
        return "RepetitiousNationalCode{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public String getMessage() {
        return "RepetitiousNationalCode{" +
                "message='" + message + '\'' +
                '}';
    }
}
