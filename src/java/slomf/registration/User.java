/*
 * A class to implement the login of a user
 */
package slomf.registration;

/**
 * @author Fiontar
 */

public class User {
    private final String link;
    private final String name;
    /**
     * Constructor of user class
     * @param link link address
     * @param name user name 
     */
    public User(String link, String name) {
        this.link = link;
        this.name = name;
    }
    /**
     * method gives the link address
     * @return link address
     */
    public String getLink() {
        return link;
    }
    /**
     * method gives the name of the user
     * @return user name
     */
    public String getName() {
        return name;
    }
}
