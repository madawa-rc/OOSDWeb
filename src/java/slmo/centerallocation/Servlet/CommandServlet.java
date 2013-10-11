/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.centerallocation.Servlet;

import admin.sendAdmissionCards;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import slmo.centerallocation.CenterAllocation;
import slmo.registration.User;
import slmo.results_processing.Marks;

/**
 *
 * @author New
 */
public class CommandServlet extends HttpServlet {

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
        User user = (User) request.getSession().getAttribute("user");
        if(user==null||!user.getName().equals("Admin"))
        {
            request.getSession().removeAttribute("user");
            response.setHeader("Refresh", "0; URL=login.jsp?id=You are not logged in as an Admin!");
            return;
        }
        if(request.getParameter("id")==null){
            response.setHeader("Refresh", "0; URL=admin.jsp");
            return;
        }
         
        if(request.getParameter("id").equals("sendAdmission")){
            sendAdmissionCards.sendtoPrivate();
            sendAdmissionCards.sendtoSchool();
            request.getSession().setAttribute("message","Admission Cards have been sent successfully!");
            response.sendRedirect("message.jsp");
        }else if(request.getParameter("id").equals("calculateMarks")){
            Marks.calculate();
            request.getSession().setAttribute("message","Marks and Ranks have been calculated successfully!");
            response.sendRedirect("message.jsp");
        }
        else if(request.getParameter("id").equals("assignCentres")){
            CenterAllocation.allocateCenters();
            CenterAllocation.assignIndex();
            request.getSession().setAttribute("message","Centers have been assigned successfully!");
            response.sendRedirect("message.jsp");
        }
        out.close();
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
