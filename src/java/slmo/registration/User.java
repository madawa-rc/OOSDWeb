/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slmo.registration;

/**
 *
 * @author Kasun
 */
public class User {
    private final String link;
    private final String name;

    public User(String link, String name) {
        this.link = link;
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }
}
