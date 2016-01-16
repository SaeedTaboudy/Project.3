/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import businessControler.ActionHandler;
import exception.DatabaseConnectionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tah
 */
public class PersonDeleteServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ActionHandler actionHandler = new ActionHandler();
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            long CustomerNumber = Long.parseLong(request.getParameter("CustomerNumber"));
            actionHandler.deleteAction("person", CustomerNumber);
            request.getRequestDispatcher("registration.jsp").forward(request, response);
            out.close();
        } catch (DatabaseConnectionException e) {
            Logger.getLogger(PersonDeleteServlet.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

}
