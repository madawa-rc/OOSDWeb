/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ReportGeneration.model;

import java.util.ArrayList;
import java.util.List;

public class Developer {

	private final String name;
	private final String lastName;
	private final String mail;
	private final List<Role> roles;

	public Developer(String name, String lastName, String mail) {
		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
		this.roles = new ArrayList<Role>();
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMail() {
		return mail;
	}

	public Developer addRole(Role role) {
		roles.add(role);
		return this;
	}

	public List<Role> getRoles() {
		return roles;
	}

}