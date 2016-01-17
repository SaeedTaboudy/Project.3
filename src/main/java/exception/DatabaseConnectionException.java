package exception;

/**
 * @author Maral Khojasteh
 */
public class DatabaseConnectionException extends Exception {
    private String message = null;

    public DatabaseConnectionException(String message1) {

        message = message1;
    }

    public DatabaseConnectionException() {
    }

    @Override
    public String toString() {
        return "DatabaseConnectionException{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public String getMessage() {
        return "DatabaseConnectionException{" +
                "message='" + message + '\'' +
                '}';
    }

}
