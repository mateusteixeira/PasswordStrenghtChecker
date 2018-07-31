package br.com.passwordstrenghtchecker.rules;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class NumbersOnlyTest {

	private NumbersOnly numbersOnly = new NumbersOnly();
	
	@Test
	public void shouldEvaluateZeroWhenNotOnlyNumbers() {

		String password = "a123";
		
		int expected = 0;
		
		int evaluation = numbersOnly.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
		
	}

	@Test
	public void shouldAssertEvaluationWhenOnlyNumbers() {

		String password = "123";
		
		int occurrenceOfNumbers = password.length();
		
		int expected = occurrenceOfNumbers * -1;
		
		int evaluation = numbersOnly.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
		
	}

	
}
