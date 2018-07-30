package br.com.passwordstrenghtchecker.service;

import br.com.passwordstrenghtchecker.entity.Password;

public class PasswordService {

	public Password check(String password) {
		Password pass = new Password();
		pass.setPassword(password);
		return pass;
	}

}
