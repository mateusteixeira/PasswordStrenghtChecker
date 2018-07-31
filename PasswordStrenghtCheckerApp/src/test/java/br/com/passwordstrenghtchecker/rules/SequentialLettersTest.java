package br.com.passwordstrenghtchecker.rules;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SequentialLettersTest {

	private static final int MULTIPLE_CONSTANT = 3;
	
	private SequentialLetters sequentialLetters = new SequentialLetters();
	
	@Test
	public void shouldAssertTheEvaluationWhenTwoOccurrenceOfSequencialUpperCaseLetters() {
		
		String password = "ABCsdaDEF12GH";
		
		int occurrences = 2;
		
		int expected = occurrences * MULTIPLE_CONSTANT * -1;
		
		int evaluation = sequentialLetters.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertTheEvaluationWhenLowerCase() {
		
		String password = "ABCsdabcDEF12GH";
		
		int occurrences = 5;
		
		int expected = occurrences * MULTIPLE_CONSTANT * -1;
		
		int evaluation = sequentialLetters.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertTheEvaluationNoneSequentialLetter() {
		
		String password = "ADBCsdabrchDEgF12GH";
		
		int occurrences = 0;
		
		int expected = occurrences * MULTIPLE_CONSTANT * -1;
		
		int evaluation = sequentialLetters.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}
}
