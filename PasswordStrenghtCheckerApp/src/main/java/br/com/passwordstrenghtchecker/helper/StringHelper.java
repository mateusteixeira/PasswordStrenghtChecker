package br.com.passwordstrenghtchecker.helper;


public class StringHelper {
	
	private StringHelper() {
	}
	
	public static String removeFirstCharacter(String password) {
		return password.substring(1);
	}
	
	public static String removeLastCharacter(String password) {
		return password.substring(0, password.length()-1);
	}

	public static String toLowerCase(String password) {
		return password.toLowerCase();
	}

}
