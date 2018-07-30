package br.com.passwordstrenghtchecker.entity;

public class Password {

	private String password;
	
	private int passwordStrength = 0;

	
	public int getPasswordStrength() {
		return passwordStrength;
	}

	public void setPasswordStrength(int passwordStrength) {
		this.passwordStrength = passwordStrength;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
