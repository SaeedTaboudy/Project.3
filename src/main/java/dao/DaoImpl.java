package dao;

import customers.BaseInformation;
import customers.Company;
import customers.Person;
import exception.DatabaseConnectionException;
import exception.RepetitiousNationalCode;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Saeed Taboudy
 */
public class DaoImpl {

    // JDBC driver name and database URL
    static final String DB_URL = "jdbc:mysql://localhost:3306/cim";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //Database credential
    static final String USER = "root";
    static final String PASS = "root";

    private static Connection getConnection() throws DatabaseConnectionException, SQLException {

        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DatabaseConnectionException();
        }

    }

    public String saveUser(Company company) throws DatabaseConnectionException, SQLException {
        try {
            Statement statement = getConnection().createStatement();
            String query;
            query = "INSERT INTO Company  (EconomicCode,Name,RegistrationDate) VALUES ('" + company.getEconomicCode() + "'"
                    + ",'" + company.getName() + "','" + company.getRegistrationDate() + "')";
            statement.executeUpdate(query);
            statement.close();
            return "Company Save";
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }

    }

    public int saveUser(Person person) throws DatabaseConnectionException, RepetitiousNationalCode {
        Statement statement;
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            throw new DatabaseConnectionException();
        }
        String query;
        query = "INSERT INTO Person(NationalCode,FirstName,LastName,FatherName,Birthday) VALUES ('" + person.getNationalCode() + "','"
                + person.getFirstName() + "','" + person.getLastName() + "','" + person.getFatherName() + "','" + person.getBirthday() + "')";
        try {
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw new RepetitiousNationalCode();
        }
        return 1;
    }

    public  String updatePerson(Person person) throws DatabaseConnectionException {
        try {
            Statement statement = getConnection().createStatement();
            String query = "UPDATE Person SET NationalCode ='" + person.getNationalCode() + "',FirstName='" + person.getFirstName() + "',LastName='"
                    + person.getLastName() + "',FatherName='" + person.getFatherName() + "',Birthday='" + person.getBirthday()
                    + "'WHERE CustomerNumber ='" + person.getCustomerNumber() + "'";
            statement.executeUpdate(query);
            statement.close();
            return "Person info update";

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseConnectionException();
        }
    }

    public  String updateCompany(Company company) throws DatabaseConnectionException {
        try {
            Statement statement = getConnection().createStatement();
            String query = "UPDATE Company SET Name ='" + company.getName() + "',EconomicCode='" + company.getEconomicCode()
                    + "',RegistrationDate='"
                    + company.getRegistrationDate() + "' WHERE CustomerNumber ='" + company.getCustomerNumber() + "'";
            statement.executeUpdate(query);
            statement.close();
            return "Company info Update";

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseConnectionException();
        }
    }

    public String userDeleting(Object obj) throws DatabaseConnectionException, SQLException {
        try {
            Statement statement = getConnection().createStatement();
            String query = "DELETE FROM " + obj.getClass().getCanonicalName().replaceAll("customers.", "") + " WHERE CustomerNumber='" + ((BaseInformation) obj).getCustomerNumber() + "'";
            statement.executeUpdate(query);
            statement.close();
            return "User delete";

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public  List<Person> search(Person person) throws DatabaseConnectionException, SQLException {
        Statement statement = getConnection().createStatement();
        boolean andFlag = false;
        String query = "SELECT * FROM person WHERE ";
        if (person.getCustomerNumber() > 0) {
            query += "CustomerNumber ='" + person.getCustomerNumber() + "'";
            andFlag = true;
        }
        if (person.getFirstName() != null)
            if (!person.getFirstName().equals("")) {
                if (andFlag) {
                    query += " AND ";

                }
                query += "FirstName ='" + person.getFirstName() + "'";
                andFlag = true;
            }
        if (person.getLastName() != null)
            if (!person.getLastName().equals("")) {
                if (andFlag) {
                    query += " AND ";

                }
                query += "LastName ='" + person.getLastName() + "'";
                andFlag = true;
            }
        if (person.getNationalCode() != null) {
            if (person.getNationalCode().compareTo(BigInteger.ZERO) > 0) {
                if (andFlag) {
                    query += " AND ";

                }
                query += "NationalCode ='" + person.getNationalCode() + "'";
            }
        }
        query += ";";

        ResultSet resultSet = statement.executeQuery(query);
        List<Person> personList = new ArrayList<>();
        while (resultSet.next()) {
            Person personResult = new Person();
            personResult.setFirstName(resultSet.getString("FirstName"));
            personResult.setLastName(resultSet.getString("LastName"));
            personResult.setFatherName(resultSet.getString("FatherName"));
            personResult.setNationalCode(BigInteger.valueOf(Long.parseLong(resultSet.getString("NationalCode"))));
            personResult.setCustomerNumber(resultSet.getLong("CustomerNumber"));
            personResult.setBirthday(resultSet.getString("Birthday"));
            personList.add(personResult);
        }
        statement.close();
        return personList;
    }

    public  List<Company> search(Company company) throws DatabaseConnectionException, SQLException {
        Statement statement = getConnection().createStatement();
        boolean andFlag = false;
        String query = "SELECT * FROM company WHERE ";
        if (company.getCustomerNumber() > 0) {
            query += "CustomerNumber ='" + company.getCustomerNumber() + "'";
            andFlag = true;
        }
        if (company.getName() != null) {
            if (andFlag) {
                query += " AND ";
            }
            query += "Name ='" + company.getName() + "'";
            andFlag = true;
        }
        if (company.getEconomicCode() > 0) {
            if (andFlag) {
                query += " AND ";
            }
            query += "EconomicCode ='" + company.getEconomicCode() + "'";
        }

        query += ";";

        ResultSet resultSet = statement.executeQuery(query);
        List<Company> companies = new ArrayList<>();
        while (resultSet.next()) {
            Company companyResult = new Company();
            companyResult.setName(resultSet.getString("Name"));
            companyResult.setEconomicCode(resultSet.getLong("EconomicCode"));
            companyResult.setCustomerNumber(resultSet.getLong("CustomerNumber"));

            companies.add(companyResult);
        }
        resultSet.close();
        statement.close();
        return companies;
    }

    public void deletAction(String type, long CustomerNumber) throws DatabaseConnectionException, SQLException {
        Statement statement = getConnection().createStatement();
        String query = "DELETE FROM " + type + " WHERE CustomerNumber= '" + CustomerNumber + "'";
        statement.executeUpdate(query);
        statement.close();
    }

    public  String searchNationalCode(String nationalCode) throws DatabaseConnectionException {
        Statement statement;
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseConnectionException();
        }
        String query = "SELECT CustomerNumber FROM person WHERE NationalCode= '" + nationalCode + "'";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                return resultSet.getString("CustomerNumber");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseConnectionException();
        }
        return null;
    }
}
