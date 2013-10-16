/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slomf.admin.center;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import slomf.admin.center.CenterDA;
import slomf.admin.result.Marks;

/**
 *
 * @author Madawa
 */
public class CenterUpdateServlet extends HttpServlet {

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
        int size = Integer.parseInt(request.getParameter("size"));
        System.out.println(size);
        
        for(int i = 1; i <= size; i++){
            CenterDA.updateCenter(
                    request.getParameter("name"+i),
                    request.getParameter("location"+i),
                    Integer.parseInt(request.getParameter("capacity"+i)),
                    Integer.parseInt(request.getParameter("classrooms"+i)),
                    request.getParameter("supervisor"+i),
                    request.getParameter("phone"+i)
                    );
            System.out.print(request.getParameter("name"+i)+" "+request.getParameter("location"+i)+" "+
                    request.getParameter("capacity"+i)+" "+request.getParameter("classrooms"+i)+" "+
                    request.getParameter("supervisor"+i)+" "+request.getParameter("phone"+i));
            System.out.println("");
        }
        out.println("<html><head></head><body>");
        out.println("<p align=\"center\"> Centre Information Successfully Updated</p>");
        out.println("<p align=\"center\"> You will be redirected to the dashboard in 5 seconds</p>");
        out.println("</body></html>");
        response.setHeader("Refresh", "5; URL=centreInformation.jsp");
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
