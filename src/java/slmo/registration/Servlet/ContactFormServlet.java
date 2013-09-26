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

/**
 *
 * @author Fointar
 */
public class ContactFormServlet extends HttpServlet{
    private String name;
    private String email;
    private String message;
    private String address;

    public ContactFormServlet() {
    }

    public ContactFormServlet(String name, String email, String message, String address) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.address = address;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException{
        response.setContentType("text/html;charset=UTF-8");
    }
}
