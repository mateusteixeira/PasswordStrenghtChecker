package br.com.passwordstrenghtchecker.rules;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class RequirementsTest {

	private static final int MULTIPLE_CONSTANT = 2;

	private Requirements requirements = new Requirements();

	@Test
	public void shouldEvaluateZeroWhenLessThanEightCharacters() {

		String password = "abc123";

		int expected = 0;

		int evaluation = requirements.analyze(password);

		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	@Test
	public void shouldEvaluateZeroWhenLessThanThreeRulesReached() {

		String password = "abc123aaaa";

		int expected = 0;

		int evaluation = requirements.analyze(password);

		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	@Test
	public void shouldAssertEvaluationWhenSymbolsNotPresent() {
		String password = "abC123abc";

		int isLowerCasePresent = 1;

		int isUpperCasePresent = 1;

		int isNumberPresent = 1;

		int equalsOrMoreThanEightCharacter = 1;

		int rulesReached = isLowerCasePresent + isUpperCasePresent + isNumberPresent + equalsOrMoreThanEightCharacter;

		int expected = rulesReached * MULTIPLE_CONSTANT;

		int evaluation = requirements.analyze(password);

		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	@Test
	public void shouldAssertEvaluationWhenNumbersNotPresent() {
		String password = "abC#%@abc";

		int isLowerCasePresent = 1;

		int isUpperCasePresent = 1;

		int isSymbolPresent = 1;

		int equalsOrMoreThanEightCharacter = 1;

		int rulesReached = isLowerCasePresent + isUpperCasePresent + isSymbolPresent + equalsOrMoreThanEightCharacter;
		int expected = rulesReached * MULTIPLE_CONSTANT;

		int evaluation = requirements.analyze(password);

		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	@Test
	public void shouldAssertEvaluationWhenLowerCaseLettersNotPresent() {
		String password = "A3C#%@2344";

		int isSymbolCasePresent = 1;

		int isUpperCasePresent = 1;

		int isNumberPresent = 1;

		int equalsOrMoreThanEightCharacter = 1;

		int rulesReached = isSymbolCasePresent + isUpperCasePresent + isNumberPresent + equalsOrMoreThanEightCharacter;

		int expected = rulesReached * MULTIPLE_CONSTANT;

		int evaluation = requirements.analyze(password);

		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	@Test
	public void shouldAssertEvaluationWhenUpperCaseLettersNotPresent() {
		String password = "a3c#%@2344";

		int isLowerCasePresent = 1;

		int isSymbolCasePresent = 1;

		int isNumberPresent = 1;

		int equalsOrMoreThanEightCharacter = 1;

		int rulesReached = isLowerCasePresent + isSymbolCasePresent + isNumberPresent + equalsOrMoreThanEightCharacter;
		
		int expected = rulesReached * MULTIPLE_CONSTANT;

		int evaluation = requirements.analyze(password);

		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

	@Test
	public void shouldAssertEvaluationWhenAllRulesReached() {
		String password = "Ab4#Abda";

		int isUpperCasePresent = 1;
		
		int isLowerCasePresent = 1;

		int isSymbolCasePresent = 1;

		int isNumberPresent = 1;

		int equalsOrMoreThanEightCharacter = 1;

		int rulesReached = isLowerCasePresent + isSymbolCasePresent + isNumberPresent + equalsOrMoreThanEightCharacter + isUpperCasePresent;

		int expected = rulesReached * MULTIPLE_CONSTANT;

		int evaluation = requirements.analyze(password);

		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

}
