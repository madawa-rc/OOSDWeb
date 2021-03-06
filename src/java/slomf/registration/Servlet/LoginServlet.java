package slomf.registration.Servlet;

import slomf.api.Database.DatabaseConnectionHandler;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import slomf.registration.Admin;
import slomf.registration.School;
import slomf.registration.User;
import slomf.registration.dao.SchoolDA;

/**
 *
 * @author Madawa
 */
public class LoginServlet extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        
        /**
         * Capture email and password from e-form login.jsp
         */
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.reset();
        md.update(request.getParameter("password").getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        
        String email = request.getParameter("email");
        String password = sb.toString();
        if((email.equals("isuruf@gmail.com")||email.equals("abkfernando@gmail.com")) && request.getParameter("password").equals("slomf")){
                slomf.admin.Log.addLog("Admin Log in");
                response.setHeader("Refresh","0; URL=admin.jsp");
                request.getSession().setAttribute("user", new Admin("Admin",email));
                return;
        }
        
        try {
            Connection con = DatabaseConnectionHandler.createConnection();
            /**
             * E-mail/password validation query
             */
            
            String queryCheck = "SELECT * from school WHERE password = ? AND email = ? ";
            slomf.admin.Log.addLog("School log in  "+email);
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, password);
            ps.setString(2, email);
            
            ResultSet resultSet = ps.executeQuery();
            /**
             * Redirection
             */
            if (resultSet.next()) 
            {    
                slomf.admin.Log.addLog("loginsuccess");
                School s=SchoolDA.getSchool(email);
                request.getSession().setAttribute("schoolObject",s);
                request.getSession().setAttribute("user", s);
                con.close();
                response.sendRedirect("schoolDashboard.jsp");
            }
            else
            {   
                con.close();
                response.setHeader("Refresh","0; URL=login.jsp?id=Invalid email address or password!");
            }
                        
        } catch (SQLException ex) {
            slomf.admin.Log.addLog(ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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