package com.beeSmartBeekeeper;

public class Owners {
	private int id;
	private String name;
	private String town;
	private String email;
	private String pass;
	
	public Owners(int id, String name, String town, String email, String pass){
		this.id=id;
		this.name=name;
		this.town=town;
		this.email=email;
		this.pass=pass;
	}
	
	public Owners(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
