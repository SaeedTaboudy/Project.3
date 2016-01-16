/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import customers.Company;
import customers.Person;
import dao.DaoImpl;
import exception.DatabaseConnectionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tah
 */
public class UpdateServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            if (request.getParameter("type").equals("person")) {

                Person person = new Person();
                person.setNationalCode(BigInteger.valueOf(Long.parseLong(request.getParameter("NationalCode"))));
                person.setFirstName(request.getParameter("FirstName"));
                person.setFatherName(request.getParameter("LastName"));
                person.setLastName(request.getParameter("FatherName"));
                person.setBirthday(request.getParameter("Birthday"));
                person.setCustomerNumber(Long.parseLong(request.getParameter("CustomerNumber")));
                DaoImpl.updatePerson(person);

            } else {
                Company company = new Company();
                if (request.getParameter("EconomicCode") != null & request.getParameter("EconomicCode").toString()!="")
                company.setEconomicCode(Long.parseLong(request.getParameter("EconomicCode")));
                company.setName(request.getParameter("Name"));
                company.setRegistrationDate(request.getParameter("RegistrationDate"));
                company.setCustomerNumber(Long.parseLong(request.getParameter("CustomerNumber")));
                DaoImpl.updateCompany(company);
            }
        } catch (DatabaseConnectionException | SQLException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("registration.jsp").forward(request, response);
        out.close();
    }

}
