package slomf.admin.servlet;

import slomf.api.Database.Constants;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import slomf.registration.User;
import slomf.admin.result.Marks;
import slomf.admin.result.ReadExcel;

public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "Uploads";
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

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
        // checks if the request actually contains upload file
        PrintWriter out = response.getWriter();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || !user.getName().equals("Admin")) {
            request.getSession().invalidate();
            response.setHeader("Refresh", "0; URL=login.jsp?id=You are not logged in as an Administrator!");
            return;
        }
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            request.getSession().setAttribute("message", "Error: Form must has enctype=multipart/form-data.");
            response.sendRedirect("message.jsp");
            return;
        }

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk 
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;

        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // parses the request's content to extract file data

            List<FileItem> formItems = upload.parseRequest(request);
            FileItem fileItem = null;
            String fileType = null;
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        fileItem = item;
                    } else {
                        fileType = item.getString();
                    }
                }
            }
            //  String filePath = uploadPath + File.separator + fileName;

            String fileName = new File(fileItem.getName()).getName();
            String message = "The following photograph names exists, <br><br>", filePath;
            boolean success = true;
            if (fileType.equals("Photographs")) {
                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (!item.isFormField()) {
                            fileItem = item;
                            fileName = new File(fileItem.getName()).getName();
                            filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            if (storeFile.exists()) {
                                message += fileName + "<br>";
                                success = false;
                            } else {
                                fileItem.write(storeFile);
                            }
                        }
                    }
                }
                if (success) {
                    message = "The photographs have been uploaded successfully!";
                }


            } else {
                filePath = Constants.LOCATION + "Uploads\\" + fileName;
                File storeFile = new File(filePath);
                // saves the file on disk
                fileItem.write(storeFile);
                ReadExcel.readResults(filePath);
                Marks.calculate();
                message = "Results have been uploaded and updated successfully!";
            }
            request.getSession().setAttribute("message", message);
            response.sendRedirect("message.jsp");
        } catch (Exception ex) {
            out.print("There was an error: " + ex.getMessage());
            ex.printStackTrace();
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
