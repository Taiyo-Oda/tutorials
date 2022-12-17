package com.emc.entities;

public class Participant extends EMBase{
	
	private String email;
	private Boolean checkdIn;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getCheckdIn() {
		return checkdIn;
	}

	public void setCheckdIn(Boolean checkdIn) {
		this.checkdIn = checkdIn;
	}

}
