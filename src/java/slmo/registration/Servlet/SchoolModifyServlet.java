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
import slmo.registration.School;
import slmo.registration.dao.SchoolDA;
import slmo.registration.dao.StudentDA;

/**
 *
 * @author Danula
 */
public class SchoolModifyServlet extends HttpServlet {

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
        
        try {
            //school
            School school = SchoolDA.getSchool(request.getParameter("email"));
            //added rows+previous student count
            int newcount = Integer.parseInt(request.getParameter("count"));
            //previous student count
            int oldCount = school.getStudentList().size();
            
            for(int i = 1; i <= newcount; i++){
                if(i <= oldCount){
                    String name = request.getParameter("studentname"+i);
                    if(name!=null&&name.equals("deleted")){
                        String id = request.getParameter("studentId"+i);
                        StudentDA.deleteStudent(id);
                    }else{
                        SchoolDA.update(
                                request.getParameter("studentId"+i),
                                request.getParameter("student"+i),
                                request.getParameter("date"+i),
                                request.getParameter("month"+i),
                                request.getParameter("year"+i),
                                request.getParameter("medium"+i)
                                );
                    }
                }
                else{
                    String name = request.getParameter("studentname"+i);
                    if(name!=null){
                        
                    }
                }
            }
        } finally {            
            
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
