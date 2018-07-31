package br.com.passwordstrenghtchecker.rules;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class LettersOnlyTest {

	private LettersOnly lettersOnly = new LettersOnly();
	
	@Test
	public void shouldAssertEvaluationWhenLettersOnly() {

		String password = "asfkaADD";
		
		int expected = password.length() * -1;
		
		int evaluation = lettersOnly.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	
	}
	
	@Test
	public void shouldAssertEvaluationWhenNotOnlyLetters() {

		String password = "asfkaADD3";
		
		int expected = 0;
		
		int evaluation = lettersOnly.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	
	}

}
