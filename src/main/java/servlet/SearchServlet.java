package servlet;

import customers.Company;
import customers.Person;
import dao.DaoImpl;
import exception.DatabaseConnectionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.SQLException;

/**
 * @author Saeed Taboudy  1/13/2016
 */
public class SearchServlet extends HttpServlet {

    public SearchServlet() {
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        DaoImpl dao = new DaoImpl();
        if (type.equals("person")) {
            Person person = new Person();
            if (!request.getParameter("CustomerNumber").isEmpty()) {
                person.setCustomerNumber(Long.valueOf(request.getParameter("CustomerNumber")));
            }
            if (request.getParameter("NationalCode")!= null & request.getParameter("NationalCode").toString()!="")
            person.setNationalCode(BigInteger.valueOf(Long.parseLong((request.getParameter("NationalCode")))));
            person.setFirstName(request.getParameter("FirstName"));
            person.setLastName(request.getParameter("LastName"));
            try {
                request.setAttribute("personsList", dao.search(person));
            } catch (DatabaseConnectionException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
  RequestDispatcher dispatcher = request.getRequestDispatcher("PersonSearchResult.jsp");

        if (dispatcher != null) {

            dispatcher.forward(request, response);

        }
        } else {
            Company company = new Company();
            if (!request.getParameter("CustomerNumber").isEmpty()) {
                company.setCustomerNumber(Long.valueOf(request.getParameter("CustomerNumber")));
            }
            if (!request.getParameter("EconomicCode").isEmpty()) {
                company.setEconomicCode(Long.valueOf(request.getParameter("EconomicCode")));
            }
            company.setName(request.getParameter("Name"));
            try {
                request.setAttribute("companyList", dao.search(company));
            } catch (DatabaseConnectionException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
              RequestDispatcher dispatcher = request.getRequestDispatcher("CompanySearchResult.jsp");

        if (dispatcher != null) {

            dispatcher.forward(request, response);

        }
        }
      
    }
}
