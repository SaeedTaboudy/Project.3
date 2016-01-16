package servlet;

import businessControler.ActionHandler;
import customers.Company;
import exception.DatabaseConnectionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CompanyRegistration extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ActionHandler actionHandler = new ActionHandler();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Company company = new Company();
        if (request.getParameter("economicCode") != null)
            company.setEconomicCode(Long.parseLong(request.getParameter("economicCode")));
        company.setName(request.getParameter("name"));
        company.setRegistrationDate(request.getParameter("registrationDate"));

        try {
            actionHandler.saveUser(company);
            company.setCustomerNumber(actionHandler.search(company).get(0).getCustomerNumber());
            request.setAttribute("company", company);
            request.getRequestDispatcher("companyShow.jsp").forward(request, response);
        } catch (DatabaseConnectionException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        out.close();
    }
}
