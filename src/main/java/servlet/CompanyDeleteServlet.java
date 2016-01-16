/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DaoImpl;
import exception.DatabaseConnectionException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tah
 */
public class CompanyDeleteServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            long CustomerNumber = Long.parseLong(request.getParameter("CustomerNumber"));
            DaoImpl.deletAction("company", CustomerNumber);
            request.getRequestDispatcher("registration.jsp").forward(request, response);
            out.close();
        } catch (DatabaseConnectionException ex) {
            Logger.getLogger(CompanyDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CompanyDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
