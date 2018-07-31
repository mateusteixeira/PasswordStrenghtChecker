package br.com.passwordstrenghtchecker.rules;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ConsecutiveUpperCaseLettersTest {

	private static final int MULTIPLE_CONSTANT = 2;
	
	private ConsecutiveUpperCaseLetters consecutiveUpperCaseLetters = new ConsecutiveUpperCaseLetters();

	@Test
	public void shouldAssertEvaluationWhenConsecutivesUpperCaseLetters() {

		String password = "ABDiwcDCD";

		int occurs = 4;
		
		int expected = occurs * MULTIPLE_CONSTANT * -1;
		
		int evaluation = consecutiveUpperCaseLetters.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));

	}
	
	@Test
	public void shouldAssertEvaluationWhenNoneConsecutivesUpperCaseLetters() {

		String password = "A3B54DiwcD3C&D";

		int expected = 0;
		
		int evaluation = consecutiveUpperCaseLetters.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));

	}

}
