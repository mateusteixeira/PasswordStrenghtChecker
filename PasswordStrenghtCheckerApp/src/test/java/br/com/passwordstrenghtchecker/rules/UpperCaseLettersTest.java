package br.com.passwordstrenghtchecker.rules;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class UpperCaseLettersTest {

	private static final int MULTIPLE_CONSTANT = 2;

	private UpperCaseLetters upperCaseLetters = new UpperCaseLetters();

	@Test
	public void shouldAssertEvaluationWhenOccursUpperCaseLetters() {

		String password = "asbAAA";

		int occurs = 3;

		int passwordLenght = 6;

		int expected = (passwordLenght - occurs) * MULTIPLE_CONSTANT;

		int evaluation = upperCaseLetters.analyze(password);

		Assert.assertThat(evaluation, Matchers.equalTo(expected));

	}

	@Test
	public void shouldAssertEvaluationWhenNotOccursUpperCaseLetters() {

		String password = "bbb";

		int expected = 0;

		int evaluation = upperCaseLetters.analyze(password);

		Assert.assertThat(evaluation, Matchers.equalTo(expected));

	}
}
