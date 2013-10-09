/*
 * A class to implement the login of a user
 */
package slmo.registration;

/**
 * @author Fiontar
 */

public class Admin extends User{
    /**
     * constructor of Admin class
     * @param name user name
     */
    public Admin(String name){
        super("admin.jsp", name);
    }
}
