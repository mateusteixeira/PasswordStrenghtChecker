package br.com.passwordstrenghtchecker.rules;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class NumberCharactersTest {

	private static final int MULTIPLE_CONSTANT = 4;
	
	private NumberCharacters numberCharacters = new NumberCharacters();
	
	@Test
	public void shouldAssertEvaluationWithPasswordLenght() {
		
		String password = "asd234";
		
		int passwordLenght = 6;
		
		int expected = passwordLenght * MULTIPLE_CONSTANT;
		
		int evaluation = numberCharacters.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
		
	}

}
