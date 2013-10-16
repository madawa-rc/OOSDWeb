/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slomf.admin.News;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import slomf.registration.User;

/**
 *
 * @author New
 */
public class NewsServlet extends HttpServlet {

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
        if (user == null || !user.getName().equals("Admin")) {
            return;
        }
        if (request.getParameter("new") != null) {
            NewsDA.addNews(request.getParameter("new"));
            System.out.println(request.getParameter("new"));
        }



        ArrayList<NewsItem> list = slomf.admin.News.NewsDA.getNews();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                int id = list.get(i).getId();
                if (request.getParameter("delete" + id) != null) {
                    NewsDA.deleteNews(id);
                } else {
                    if (request.getParameter("show" + id) != null) {
                        System.out.println("show " + id);
                        NewsDA.show(id, 1);
                    } else {
                        NewsDA.show(id, 0);
                    }
                }
            }
            NewsDA.processNews();
            if (request.getParameter("main") != null) {
                try {
                    System.out.println(request.getParameter("main"));
                    NewsDA.setMainNews(Integer.parseInt(request.getParameter("main")));
                } catch (Exception e) {
                }
            }
        }
        NewsDA.processNews();
        response.sendRedirect("newsDashboard.jsp");
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
