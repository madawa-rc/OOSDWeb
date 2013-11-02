/*
 * A class to implement the login of a user
 */
package slomf.registration;

/**
 * @author Fiontar
 */

public class Admin extends User{
    /**
     * constructor of Admin class
     * @param name user name
     */
    private String email;
    public Admin(String name, String email){
        super("admin.jsp", name);
        this.email=email; 
    }

    public String getEmail() {
        return email;
    }
    
}
