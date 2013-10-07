/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.registration.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import slmo.registration.School;
import slmo.registration.Student;
import slmo.registration.UniqueID;
import slmo.registration.dao.StudentDA;

/**
 *
 * @author Madawa
 */
public class AddSchoolManualServlet extends HttpServlet {

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
        
        int studentCount = Integer.parseInt(request.getParameter("num"));
        
        School school = new School(
                request.getParameter("contactname"),
                request.getParameter("email"),
                request.getParameter("name"),
                "password",
                request.getParameter("school_addr"),
                request.getParameter("phone"),
                request.getParameter("preferred_centre"),
                "1"
                );
        
        for (int i = 1; i <= studentCount; i++) {
                String name = request.getParameter("student" + i);
                System.out.println(name);
                if (name != null) {
                    Student s = school.addStudent(
                            request.getParameter("student" + i),
                            Integer.parseInt(request.getParameter("date" + i)),
                            Integer.parseInt(request.getParameter("month" + i)),
                            Integer.parseInt(request.getParameter("year" + i)),
                            request.getParameter("medium" + i));
                    System.out.println(request.getParameter("student" + i));
                    StudentDA.addStudent(s);
                }

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
