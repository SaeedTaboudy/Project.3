package businessControler;

import customers.Company;
import customers.Person;
import dao.DaoImpl;
import exception.DatabaseConnectionException;
import exception.RepetitiousNationalCode;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Saeed Taboudy  1/16/2016
 */
public class ActionHandler {
    private static DaoImpl dao = new DaoImpl();

    public void deleteAction(String type, long CustomerNumber) throws DatabaseConnectionException {
        try {
            dao.deletAction(type, CustomerNumber);
        } catch (DatabaseConnectionException | SQLException e) {
            throw new DatabaseConnectionException();
        }
    }

    public List<Company> search(Company company) throws DatabaseConnectionException {
        try {
            return dao.search(company);
        } catch (DatabaseConnectionException | SQLException e) {
            throw new DatabaseConnectionException();
        }
    }

    public int saveUser(Person person) throws DatabaseConnectionException, RepetitiousNationalCode {
        try {
            return dao.saveUser(person);
        } catch (DatabaseConnectionException e) {
            throw new DatabaseConnectionException();
        } catch (RepetitiousNationalCode repetitiousNationalCode) {
            throw new RepetitiousNationalCode();
        }
    }

    public String saveUser(Company company) throws DatabaseConnectionException {
        try {
            return dao.saveUser(company);
        } catch (DatabaseConnectionException | SQLException e) {
            throw new DatabaseConnectionException();
        }
    }

    public static List<Person> search(Person person) throws DatabaseConnectionException {
        try {
            return dao.search(person);
        } catch (DatabaseConnectionException | SQLException e) {
            throw new DatabaseConnectionException();
        }
    }

    public static String searchNationalCode(String nationalCode) throws DatabaseConnectionException {
        try {
            return dao.searchNationalCode(nationalCode);
        } catch (DatabaseConnectionException e) {
            throw new DatabaseConnectionException();
        }
    }

    public String updatePerson(Person person) throws DatabaseConnectionException {
        try {
            return dao.updatePerson(person);
        } catch (DatabaseConnectionException e) {
            throw new DatabaseConnectionException();
        }
    }

    public  String updateCompany(Company company) throws DatabaseConnectionException {
        try {
            return dao.updateCompany(company);
        } catch (DatabaseConnectionException e) {
            throw new DatabaseConnectionException();
        }
    }

}
