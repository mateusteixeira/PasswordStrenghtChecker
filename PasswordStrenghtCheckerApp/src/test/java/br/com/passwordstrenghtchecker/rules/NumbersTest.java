package br.com.passwordstrenghtchecker.rules;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class NumbersTest {

	private static final int MULTIPLE_CONSTANT = 4;
	
	private Numbers numbers = new Numbers();
	
	@Test
	public void shouldAssertEvaluationWithOccurrencesOfNumbers() {
		
		String password = "asd234";
		
		int occurrences = 3;
		
		int expected = occurrences * MULTIPLE_CONSTANT;
		
		int evaluation = numbers.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
		
	}
}
