package slomf.admin.servlet;

import slomf.admin.ExportStudentList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.net.ftp.FTPClient;
import slomf.admin.center.ExamCenter;
import slomf.admin.center.CenterDA;
import slomf.api.Database.FTPTransfer;
import slomf.api.reportGeneration.Report;
import slomf.registration.School;
import slomf.registration.User;
import slomf.registration.dao.SchoolDA;

public class DownloadServlet extends HttpServlet {

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
    static final long serialVersionUID = 1L;
    private static final int BUFSIZE = 4096;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getName().equals("Admin")) {
            request.getSession().removeAttribute("user");
            response.setHeader("Refresh", "0; URL=login.jsp?id=You are not logged in as an Administrator!");
            return;
        }
        
        InputStream inStream = null;
        FTPClient ftp = FTPTransfer.setup(true);
        response.setContentType("application/octet-stream");
        OutputStream outStream = response.getOutputStream();

        if (request.getParameter("name").equals("Templates")) {
            response.setHeader("Content-Disposition", "attachment; filename=\"" + request.getParameter("template") + "\"");
            ftp.retrieveFile(request.getParameter("template"), outStream);
        } else if (request.getParameter("name").equals("Defaults")) {
            response.setHeader("Content-Disposition", "attachment; filename=\"" + request.getParameter("template") + "\"");
            ftp.retrieveFile("Defaults/" + request.getParameter("template"), outStream);
        }
        else if (request.getParameter("name").equals("Database")) {
            response.setHeader("Content-Disposition", "attachment; filename=\"" + "Database.xlsx" + "\"");
            ExportStudentList.exportStudentsToExcel(outStream);
        } else if (request.getParameter("name").equals("AttendanceSheets")) {
            inStream = ftp.retrieveFileStream("AttendanceSheet.docx");
            ArrayList<ExamCenter> centers = CenterDA.getAllPopulatedCenters();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + "AttendanceSheet.docx" + "\"");
            Report.generate(inStream, "centers", centers, outStream);
        } else if (request.getParameter("name").equals("Classrooms")) {
            inStream = ftp.retrieveFileStream("Classroom.docx");
            ArrayList<ExamCenter> centers = CenterDA.getAllPopulatedCenters();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + "Classroom.docx" + "\"");
            Report.generate(inStream, "centers", centers, outStream);
        } else if (request.getParameter("name").equals("ResultSheet")) {
            inStream = ftp.retrieveFileStream("ResultsSchool.docx");
            ArrayList<School> allSchools = SchoolDA.getAllSchools();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + "ResultsSchool.docx" + "\"");
            Report.generate(inStream, "schools", allSchools, outStream);
        } else {
            return;
        }
        if (inStream != null) {
            inStream.close();
        }
        outStream.close();
        FTPTransfer.disconnect(ftp);
        /*
         response.setContentType("text/html;charset=UTF-8");

         File file = new File(filePath);
         int length = 0;
         ServletOutputStream outStream = response.getOutputStream();
         ServletContext context = getServletConfig().getServletContext();
         String mimetype = context.getMimeType(filePath);

         // sets response content type
         if (mimetype == null) {
         mimetype = "application/octet-stream";
         }
         response.setContentType(mimetype);
       
         response.setContentLength((int) file.length());
         String fileName = (new File(filePath)).getName();

         // sets HTTP header
         response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

         byte[] byteBuffer = new byte[BUFSIZE];
         //       DataInputStream in = new DataInputStream(new FileInputStream(file));
         DataInputStream in = new DataInputStream(fis);
        
         // reads the file's bytes and writes them to the response stream
         while ((in != null) && ((length = in.read(byteBuffer)) != -1)) {
         outStream.write(byteBuffer, 0, length);
         }

         in.close();
         outStream.close();*/
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
