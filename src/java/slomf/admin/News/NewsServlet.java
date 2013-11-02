package slomf.admin.News;

import com.sun.net.httpserver.Filter.Chain;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import slomf.registration.User;

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
        slomf.admin.Log.addLog(request.getCharacterEncoding());
        if (request.getParameter("newNews") != null) {
            String news = new String(request.getParameter("newNews").getBytes("8859_1"),"UTF-8");
            String title = new String(request.getParameter("newTitle").getBytes("8859_1"),"UTF-8");
            NewsDA.addNews(news, title);
            slomf.admin.Log.addLog("News Added "+news);
            response.sendRedirect("newsDashboard.jsp");
            return;
        }

        ArrayList<NewsItem> list = NewsDA.getNews();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                int id = list.get(i).getId();
                if (request.getParameter("delete" + id) != null) {
                    NewsDA.deleteNews(id);
                } else {
                    boolean show=false,main=false,article=false;
                    if (request.getParameter("show" + id) != null) 
                        show=true;
                    if (request.getParameter("main" + id) != null) 
                        main=true;
                    if (request.getParameter("article" + id) != null) 
                        article=true;
                    String editNews = new String(request.getParameter("editNews" + id).getBytes("8859_1"),"UTF-8"); 
                    String editTitle = new String(request.getParameter("editTitle" + id).getBytes("8859_1"),"UTF-8"); 
                    NewsItem item = new NewsItem(editNews,editTitle,id,show,main,article);
                    NewsDA.updateNews(item);  
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
