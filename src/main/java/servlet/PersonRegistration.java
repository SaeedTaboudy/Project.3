package servlet;


import businessControler.ActionHandler;
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


public class PersonRegistration extends HttpServlet {
    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ActionHandler actionHandler = new ActionHandler();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Person person = new Person();
        person.setNationalCode(BigInteger.valueOf(Long.parseLong(request.getParameter("nationalCode"))));
        person.setFirstName(request.getParameter("firstName"));
        person.setFatherName(request.getParameter("lastName"));
        person.setLastName(request.getParameter("fatherName"));
        person.setBirthday(request.getParameter("birthday"));

        try {
            if (actionHandler.searchNationalCode(request.getParameter("nationalCode")) != null)
                throw new RepetitiousNationalCode();

            DaoImpl dao = new DaoImpl();
            if (dao.saveUser(person) > 0) {
                person.setCustomerNumber(actionHandler.search(person).get(0).getCustomerNumber());
                request.setAttribute("person", person);
                request.getRequestDispatcher("personShow.jsp").forward(request, response);
            }
        } catch (DatabaseConnectionException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } catch (RepetitiousNationalCode e) {
            request.setAttribute("message", "RepetitiousNationalCode Error....");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        out.close();
    }
}
