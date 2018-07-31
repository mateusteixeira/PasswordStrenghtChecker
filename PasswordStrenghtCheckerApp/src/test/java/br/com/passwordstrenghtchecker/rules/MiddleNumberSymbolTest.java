package br.com.passwordstrenghtchecker.rules;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class MiddleNumberSymbolTest {

	private static final int MULTIPLE_CONSTANT = 2;
	
	private MiddleNumberSymbol middleNumberSymbol = new MiddleNumberSymbol();
	
	@Test
	public void shouldEvaluateZeroWhenLenghtLessOrEqualThree() {

		String password = "as";
		
		int expected = 0;
		
		int evaluation = middleNumberSymbol.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
		
	}
	
	@Test
	public void shouldAssertEvaluationWhenOnlyNumbersInMiddle() {
		
		String password = "Ass23D";
		
		int occurrenceOfNumbers = 2;
		
		int occurrenceOfSymbols = 0;
		
		int expected = (occurrenceOfNumbers + occurrenceOfSymbols) * MULTIPLE_CONSTANT;
		
		int evaluation = middleNumberSymbol.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	@Test
	public void shouldAssertEvaluationWhenOnlySymbolsInMiddle() {
		
		String password = "Ass#$@D";
		
		int occurrenceOfNumbers = 0;
		
		int occurrenceOfSymbols = 3;
		
		int expected = (occurrenceOfNumbers + occurrenceOfSymbols) * MULTIPLE_CONSTANT;
		
		int evaluation = middleNumberSymbol.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertEvaluationWhenNumbersAndSymbolsInMiddle() {
		
		String password = "Ass#$@D43d";
		
		int occurrenceOfNumbers = 2;
		
		int occurrenceOfSymbols = 3;
		
		int expected = (occurrenceOfNumbers + occurrenceOfSymbols) * MULTIPLE_CONSTANT;
		
		int evaluation = middleNumberSymbol.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertEvaluationWhenNumbersAsFirstCharacter() {
		
		String password = "3ss#$@D433";
		
		int occurrenceOfNumbers = 2;
		
		int occurrenceOfSymbols = 3;
		
		int expected = (occurrenceOfNumbers + occurrenceOfSymbols) * MULTIPLE_CONSTANT;
		
		int evaluation = middleNumberSymbol.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertEvaluationWhenNumbersAsLastCharacter() {
		
		String password = "3ss#$@D43";
		
		int occurrenceOfNumbers = 1;
		
		int occurrenceOfSymbols = 3;
		
		int expected = (occurrenceOfNumbers + occurrenceOfSymbols) * MULTIPLE_CONSTANT;
		
		int evaluation = middleNumberSymbol.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	@Test
	public void shouldAssertEvaluationWhenSymbolAsFirstCharacter() {
		
		String password = "#3ss#$@D43";
		
		int occurrenceOfNumbers = 2;
		
		int occurrenceOfSymbols = 3;
		
		int expected = (occurrenceOfNumbers + occurrenceOfSymbols) * MULTIPLE_CONSTANT;
		
		int evaluation = middleNumberSymbol.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertEvaluationWhenSymbolAsLastCharacter() {
		
		String password = "#3ss#$@D43#";
		
		int occurrenceOfNumbers = 3;
		
		int occurrenceOfSymbols = 3;
		
		int expected = (occurrenceOfNumbers + occurrenceOfSymbols) * MULTIPLE_CONSTANT;
		
		int evaluation = middleNumberSymbol.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	
}
