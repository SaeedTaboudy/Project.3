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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tah
 */
public class PersonLoadServlet  extends HttpServlet{

    public PersonLoadServlet() {
    }
    
        public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html");
        PrintWriter out = response.getWriter();
                    Person person=new Person();
       if (request.getParameter("CustomerNumber")!=null & request.getParameter("CustomerNumber")!=""){
                try {
                    person.setCustomerNumber(Long.parseLong(request.getParameter("CustomerNumber")));
                    List<Person> lst=DaoImpl.search(person);
                    if (lst!= null)
                        person=lst.get(0);
                } catch (DatabaseConnectionException | SQLException ex) {
                    Logger.getLogger(PersonLoadServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                  request.setAttribute("person",person);
                   RequestDispatcher dispatcher = request.getRequestDispatcher("personEdit.jsp");

        if (dispatcher != null) {

            dispatcher.forward(request, response);

        }
       }
        }
}
