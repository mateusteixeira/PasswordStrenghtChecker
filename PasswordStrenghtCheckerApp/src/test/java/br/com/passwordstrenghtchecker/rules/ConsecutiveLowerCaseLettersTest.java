package br.com.passwordstrenghtchecker.rules;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ConsecutiveLowerCaseLettersTest {

	private static final int MULTIPLE_CONSTANT = 2;
	
	private ConsecutiveLowerCaseLetters consecutiveLowerCaseLetters = new ConsecutiveLowerCaseLetters();
	
	@Test
	public void shouldAssertEvaluationWhenTwoConsecutivesOccurrence() {

		String password = "ABDiwcDCD";
		
		int occurs = 2;
		
		int expected = occurs * MULTIPLE_CONSTANT * -1;
	
		int evaluation = consecutiveLowerCaseLetters.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	@Test
	public void shouldAssertEvaluationWhenNoneConsecutivesOccurrence() {

		String password = "ABDDCD";
		
		int expected = 0;
	
		int evaluation = consecutiveLowerCaseLetters.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	
}
