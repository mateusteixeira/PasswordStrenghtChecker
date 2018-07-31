package br.com.passwordstrenghtchecker.rules;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class LowerCaseLettersTest {

	private static final int MULTIPLE_CONSTANT = 2;
	
	private LowerCaseLetters lowerCaseLetters = new LowerCaseLetters();
	
	@Test
	public void shouldAssertEvaluationWhenOccursLowerCaseLetters() {

		String password = "asbAAA";
		
		int occurs = 3;
		
		int passwordLenght = 6;
		
		int expected = (passwordLenght - occurs) * MULTIPLE_CONSTANT;
		
		int evaluation = lowerCaseLetters.analyze(password);
		
		Assert.assertThat(evaluation , Matchers.equalTo(expected));
		
	}
	
	@Test
	public void shouldAssertEvaluationWhenNotOccursLowerCaseLetters() {

		String password = "AAA";
		
		int expected = 0;
		
		int evaluation = lowerCaseLetters.analyze(password);
		
		Assert.assertThat(evaluation , Matchers.equalTo(expected));
		
	}

}
