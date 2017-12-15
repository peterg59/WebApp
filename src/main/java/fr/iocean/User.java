package fr.iocean;

public class User {
	
	private int id;
	private String firstName, lastName, email, password;
	
	@Override
	public String toString() {
		return "{id : " + id + ", firstName : " + firstName + ", lastName : " + lastName + ", email : " + email + ", password : " + password + "}";
	}
}
