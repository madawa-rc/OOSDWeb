package slmo.registration.Servlet;
import Database.DatabaseConnectionHandler;
import admin.sendAdmissionCards;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailConfirmation extends HttpServlet {

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
            new sendAdmissionCards().sendtoPrivate();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmailConfirmation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(request.getParameter("id"));
            DatabaseConnectionHandler dbc=null;
            Connection con=null;
            try {
                dbc = new DatabaseConnectionHandler();
                con = dbc.getConnection();
                String link = request.getParameter("id");
            Statement st = con.createStatement();
         //   st.executeUpdate("INSERT INTO student VALUES ('"+student.getName()+"','2013-01-01','1','1','1','1','1','1','1','1','1','1','1','443','1','1','12','1','1');");
            String queryCheck = "UPDATE student SET verified=1 WHERE verification =?";
            PreparedStatement ps = con.prepareStatement(queryCheck);
            ps.setString(1, link);
            ps.executeUpdate();
            } catch (Exception ex) {
               
            }
            
            
           
            
            out.println("<h1>Servlet EmailConfirmation at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
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
