package fr.jcjTeam.theSocialNetwork.beans;

public class User {

	private String id;
	private String name;
	private String surname;
	private String password;
	private Boolean administrator;
	
	public User(){
		
	}
	
	public User(String id, String name, String surname, Boolean administrator){
		this.id = id;
		this.administrator = administrator;
		this.name = name;
		this.surname = surname;
	}
	
	public User(String id, String name, String surname, String password, Boolean administrator){
		this.id = id;
		this.password = password;
		this.administrator = administrator;
		this.name = name;
		this.surname = surname;
	}
	
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public Boolean getAdministrator() {
		return administrator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}
