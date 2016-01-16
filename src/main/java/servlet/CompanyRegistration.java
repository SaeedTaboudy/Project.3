package servlet;

import customers.Company;
import dao.DaoImpl;
import exception.DatabaseConnectionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class CompanyRegistration extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Company company = new Company();
        if (request.getParameter("economicCode") != null)
            company.setEconomicCode(Long.parseLong(request.getParameter("economicCode")));
        company.setName(request.getParameter("name"));
        company.setRegistrationDate(request.getParameter("registrationDate"));

        DaoImpl dao = new DaoImpl();

        try {
            dao.saveUser(company);
            company.setCustomerNumber(dao.search(company).get(0).getCustomerNumber());
            request.setAttribute("company", company);
            request.getRequestDispatcher("companyShow.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } catch (DatabaseConnectionException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

//            out.print("Your CustomerNumber is: " + temp);
        out.close();
    }
}
