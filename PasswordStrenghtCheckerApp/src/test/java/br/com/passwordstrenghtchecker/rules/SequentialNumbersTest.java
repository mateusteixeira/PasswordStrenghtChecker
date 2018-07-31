package br.com.passwordstrenghtchecker.rules;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SequentialNumbersTest {

	private static final int MULTIPLE_CONSTANT = 3;
	
	private SequentialNumbers sequentialNumbers = new SequentialNumbers();
	
	@Test
	public void shouldAssertEvaluationWhenOneSequentialOfNumbers() {
		
		String password = "ABC123DEF124GH";
		
		int occurrences = 1;
		
		int expected = occurrences *  MULTIPLE_CONSTANT * -1;
		
		int evaluation = sequentialNumbers.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertEvaluationWhenNoneSequentialOfNumbers() {
		
		String password = "ABC1273DEF124GH";
		
		int occurrences = 0;
		
		int expected = occurrences *  MULTIPLE_CONSTANT * -1;
		
		int evaluation = sequentialNumbers.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

}
