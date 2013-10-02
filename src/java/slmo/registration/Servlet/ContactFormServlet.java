/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.registration.Servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Mail.recieveMail;

/**
 *
 * @author Fointar
 */
public class ContactFormServlet extends HttpServlet{
    private String name;
    private String email;
    private String message;
    private String address;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException{
        //response.setContentType("text/html;charset=UTF-8");
        name = request.getParameter("name");
        address = request.getParameter("address");
        email = request.getParameter("email");
        message = request.getParameter("message");
        recieveMail.recieveMail(name, address, email, message);
    }
}
