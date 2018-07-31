package br.com.passwordstrenghtchecker.rules;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ConsecutiveNumbersTest {

	private static final int MULTIPLE_CONSTANT = 2;
	
	private ConsecutiveNumbers consecutiveNumbers = new ConsecutiveNumbers();
	
	@Test
	public void shouldAssertTheEvaluationWhenConsecutivesNumbers() {
		String password = "AB23Diw333cDCD222";
		
		int occurs = 5;
		
		int expected = occurs * MULTIPLE_CONSTANT * -1;
		
		int evaluation = consecutiveNumbers.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
		
	}

	@Test
	public void shouldAssertTheEvaluationWhenNoneConsecutivesNumbers() {
		String password = "AB2Diw3cDCD2";
		
		int expected = 0;
		
		int evaluation = consecutiveNumbers.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
		
	}
}
