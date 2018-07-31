package br.com.passwordstrenghtchecker.rules;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SymbolsTest {

	private static final int MULTIPLE_CONSTANT = 6;

	private Symbols symbols = new Symbols();

	@Test
	public void shouldAssertEvaluationWithOccurrencesOfNumbers() {

		String password = "as%d$234#";

		int occurrences = 3;

		int expected = occurrences * MULTIPLE_CONSTANT;

		int evaluation = symbols.analyze(password);

		Assert.assertThat(evaluation, Matchers.equalTo(expected));

	}

}
