/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slomf.registration.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import slomf.registration.School;
import slomf.registration.UniqueID;
import slomf.registration.dao.SchoolDA;

/**
 *
 * @author DELL
 */
public class SchoolRegistrationServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SchoolServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SchoolServlet at " + request.getContextPath() + "</h1>");
            if(UniqueID.searchSchoolEmail(request.getParameter("email")))
            {
                System.out.println("Email is already registered. "+request.getParameter("email"));
                response.setHeader("Refresh", "10; URL=schoolRegistration.jsp");
                return;
            }
            out.println("</body>");
            out.println("</html>");
        } finally {            
          //  out.close();
        }
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.reset();
        md.update(request.getParameter("password").getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        
        School s = new School(
                request.getParameter("contactname"),
                request.getParameter("email"),
                request.getParameter("name"),
                sb.toString(),
                request.getParameter("school_addr"),
                request.getParameter("phone"),
                request.getParameter("preferred_centre"),
                UniqueID.generate()
                );
        try {
            SchoolDA.addSchool(s);
            System.out.println("School registered "+s.getEmail());

            request.getSession().setAttribute("schoolObject",s);
            request.getSession().setAttribute("user", s);
            response.sendRedirect("schoolDashboard.jsp");

         
        } catch (Exception ex) {
            out.println("*******Problem in connecting to the database*********");
            String sErrorMessage = ex.getMessage();
            out.println(sErrorMessage);
            out.println("--------------------");
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
            Logger.getLogger(SchoolRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SchoolRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
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
