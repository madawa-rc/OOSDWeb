/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.registration.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Database.DatabaseConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import slmo.registration.dao.SchoolDA;

/**
 *
 * @author Madawa
 */
public class SchoolLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        /**
         * Capture email and password from e-form login.jsp
         */
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        DatabaseConnectionHandler dbc = new DatabaseConnectionHandler();
        
        try {
            Connection con = dbc.getConnection();
            /**
             * E-mail/password validation query
             */
            String queryCheck = "SELECT * from school WHERE password = ? AND email = ? ";
            
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, password);
            ps.setString(2, email);
            
            ResultSet resultSet = ps.executeQuery();
            
            /**
             * Redirection
             */
            if (resultSet.next()) 
            {    
                System.out.println("loginsuccess");
                request.setAttribute("schoolObject",SchoolDA.getSchool(email));
                RequestDispatcher rd = request.getRequestDispatcher("schoolDashboard.jsp");       
                rd.forward(request, response);
            }
            else
                response.setHeader("Refresh","0; URL=login.jsp");
                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
