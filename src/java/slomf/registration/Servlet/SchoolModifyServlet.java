/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slomf.registration.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import slomf.registration.School;
import slomf.registration.Student;
import slomf.registration.dao.SchoolDA;
import slomf.registration.dao.StudentDA;

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
        School school =null;
            //school
            school = SchoolDA.getSchool(request.getParameter("email"));
            //added rows+previous student count
            int newcount = Integer.parseInt(request.getParameter("num"));
            //previous student count
            slomf.admin.Log.addLog("School modified "+school.getEmail());
            int oldCount = school.getStudentList().size();
            String[] ids = new String[oldCount];
            for (int i = 1; i <= oldCount; i++) {
                String name = request.getParameter("student" + i);
                if (name != null) {
                    ids[i - 1] = request.getParameter("studentId" + i);
                    StudentDA.update(school.getStudentList().get(i - 1),
                            request.getParameter("student" + i),
                            request.getParameter("date" + i),
                            request.getParameter("month" + i),
                            request.getParameter("year" + i),
                            request.getParameter("medium" + i));
                }
            }
            Student[] ss = new Student[oldCount];
            for (int i = 0; i < oldCount; i++) {
                boolean found = false;
                String id = school.getStudentList().get(i).getId() + "";
                slomf.admin.Log.addLog("student id = " + id + "p");
                for (int j = 0; j < oldCount; j++) {
                    if (ids[j] != null && ids[j].equals(id)) {
                        found = true;
                    }
                }
                if (found == false) {
                    ss[i] = school.getStudentList().get(i);
                }
            }
            for (int i = 0; i < oldCount; i++) {

                if (ss[i] != null) {
                    SchoolDA.deleteStudent(school, ss[i]);
                    slomf.admin.Log.addLog("deleting " + ss[i].getName() + "p");
                }
            }

            for (int i = oldCount + 1; i <= newcount; i++) {
                String name = request.getParameter("student" + i);
                slomf.admin.Log.addLog(name);
                if (name != null) {
                    Student s = school.addStudent(
                            request.getParameter("student" + i),
                            Integer.parseInt(request.getParameter("date" + i)),
                            Integer.parseInt(request.getParameter("month" + i)),
                            Integer.parseInt(request.getParameter("year" + i)),
                            request.getParameter("medium" + i));
                    slomf.admin.Log.addLog(request.getParameter("student" + i));
                    StudentDA.addStudent(s);
                }

            }
            school=SchoolDA.getSchool(school.getEmail());
            request.getSession().setAttribute("schoolObject", school);
            request.getSession().setAttribute("user", school);
            response.sendRedirect("schoolDashboard.jsp");
            //    request.setAttribute("schoolObject", SchoolDA.getSchool(request.getParameter("email"))); // Login user.
            //  response.sendRedirect("schoolDashboard.jsp");
        
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
