package br.com.passwordstrenghtchecker.rules;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SequentialSymbolsTest {

	private static final int MULTIPLE_CONSTANT = 3;
	
	private SequentialSymbols sequentialSymbols = new SequentialSymbols();
	
	@Test
	public void shouldAssertTheEvaluationWhenSequencialSymbolsOccursOneTime() {
		
		String password = "ABC123DEF124GH;<=";
		
		int occurrences = 1;
		
		int expected = occurrences * MULTIPLE_CONSTANT * -1;
		
		int evaluation = sequentialSymbols.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	@Test
	public void shouldAssertTheZeroWhenNotOccursSequencialSymbols() {
		
		String password = "ABC123DEF124GH;<$=";
		
		int occurrences = 0;
		
		int expected = occurrences * MULTIPLE_CONSTANT * -1;
		
		int evaluation = sequentialSymbols.analyze(password);
		
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}
	
}
