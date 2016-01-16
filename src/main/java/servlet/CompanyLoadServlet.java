/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import customers.Company;
import dao.DaoImpl;
import exception.DatabaseConnectionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tah
 */
public class CompanyLoadServlet extends HttpServlet {

    public CompanyLoadServlet() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Company company = new Company();
        if (request.getParameter("CustomerNumber") != null & !request.getParameter("CustomerNumber").equals("")) {
            try {
                company.setCustomerNumber(Long.parseLong(request.getParameter("CustomerNumber")));
                List<Company> lst = DaoImpl.search(company);
                if (lst != null) {
                    company = lst.get(0);
                }
            } catch (DatabaseConnectionException | SQLException ex) {
                Logger.getLogger(CompanyLoadServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("company", company);
            RequestDispatcher dispatcher = request.getRequestDispatcher("companyEdit.jsp");

            if (dispatcher != null) {

                dispatcher.forward(request, response);

            }
            out.close();
        }
    }
}
