/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slomf.registration.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import slomf.registration.Student;
import slomf.registration.dao.StudentDA;
import slomf.registration.UniqueID;

/**
 *
 * @author Madawa
 */
public class StudentRegistrationServlet extends HttpServlet {

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
            if(UniqueID.searchStudentEmail(request.getParameter("email")))
            {
                out.println("Email is already registered.");
                response.setHeader("Refresh", "10; URL=register.jsp");
                return;
            }
            System.out.println("adsadsasasdas");
            out.println(request.getParameter("name"));
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            // out.close();
        }
    
        Student s = new Student(
                request.getParameter("name"),
                Integer.parseInt(request.getParameter("date")),
                Integer.parseInt(request.getParameter("date")),
                Integer.parseInt(request.getParameter("date")),
                request.getParameter("email"),
                request.getParameter("school"),
                request.getParameter("school_addr"),
                request.getParameter("home_addr"),
                1,
                request.getParameter("phone"),
                request.getParameter("medium"),
                request.getParameter("preferred_centre"),
                UniqueID.generate()
                );
        try {
            StudentDA.addStudent(s);
            out.println("Please wait while we send you the verification email and redirect you.");
            out.close();
            StudentDA.sendVerification(s);
            System.out.println("email sent to "+s.getEmail());

         
        } catch (Exception ex) {
            out.println("*******Problem in connecting to the database*********");
            String sErrorMessage = ex.getMessage();
            out.println(sErrorMessage);
            out.println("--------------------");
            out.close();
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
