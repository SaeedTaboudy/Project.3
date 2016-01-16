package servlet;


import customers.Person;
import dao.DaoImpl;
import exception.DatabaseConnectionException;
import exception.RepetitiousNationalCode;

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


public class PersonRegistration extends HttpServlet {
    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        long temp = 0;
        Person person = new Person();

        if (request.getParameter("CustomerNumber") != null & request.getParameter("CustomerNumber") != "") {
            try {
                temp = Long.parseLong(request.getParameter("CustomerNumber"));
                person.setCustomerNumber(temp);
                person = DaoImpl.search(person).get(0);
            } catch (DatabaseConnectionException ex) {
                Logger.getLogger(PersonRegistration.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("message", ex.getMessage());
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(PersonRegistration.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("message", ex.getMessage());
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }
        }
        person.setNationalCode(BigInteger.valueOf(Long.parseLong(request.getParameter("nationalCode"))));
        person.setFirstName(request.getParameter("firstName"));
        person.setFatherName(request.getParameter("lastName"));
        person.setLastName(request.getParameter("fatherName"));
        person.setBirthday(request.getParameter("birthday"));

        try {
            if (DaoImpl.searchNationalCode(request.getParameter("nationalCode")) != null)
                throw new RepetitiousNationalCode();

            DaoImpl dao = new DaoImpl();
            if (dao.saveUser(person) > 0) {
                person.setCustomerNumber(dao.search(person).get(0).getCustomerNumber());
                request.setAttribute("person", person);
                request.getRequestDispatcher("personShow.jsp").forward(request, response);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (RepetitiousNationalCode e) {

            request.setAttribute("message","RepetitiousNationalCode Error....");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } catch (DatabaseConnectionException e1) {
            e1.printStackTrace();
        }
        out.close();
    }

}
