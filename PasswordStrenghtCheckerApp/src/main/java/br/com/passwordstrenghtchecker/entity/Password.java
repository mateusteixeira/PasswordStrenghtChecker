package br.com.passwordstrenghtchecker.entity;

public class Password {

	private String passwordDescription;
	
	private int passwordStrength = 0;

	private String complexityDescription;

	public Password(String passwordDescription, int passwordStrength, String complexityDescription) {
		this.passwordDescription = passwordDescription;
		this.passwordStrength = passwordStrength;
		this.complexityDescription = complexityDescription;
	}


	public String getPasswordDescription() {
		return passwordDescription;
	}
	public int getPasswordStrength() {
		return passwordStrength;
	}

	public String getComplexityDescription() {
		return complexityDescription;
	}
	
	
	
}
