/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Madawa
 */
public class StudentServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(request.getParameter("name"));
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            // out.close();
        }

       // Student s = new Student(123, null, null, null, null, null, null, null, null, true, true, true);//Should be initailized
        Student s = new Student();
        s.setName(request.getParameter("name"));
 /*       s.setDob((request.getParameter("dob")));
        s.setEmail(request.getParameter("email"));
        s.setDob(request.getParameter("dob"));
            ps.setDate(2, student.getDob());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getSchool());
            ps.setString(5, student.getSchool_addr());
            ps.setString(6, student.getHome_addr());
            ps.setInt(7, student.getPvt_applicant());
            ps.setString(8, student.getPhone());
            ps.setString(9, student.getMedium());
            ps.setString(10, student.getPreferred_centre());*/
        
        try {
            Class.forName("com.mysql.jdbc.Driver");//put the j connector to the lib folde h if not working
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oosd", "root", "123456");
            Statement st = con.createStatement();

         
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
