package br.com.passwordstrenghtchecker.helper;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class StringHelperTest {

	@Test
	public void shouldAssertStringWithOutFirstCharacter() {

		String password = "abcdefg123";

		String expected = "bcdefg123";

		String removedFirstCharacter = StringHelper.removeFirstCharacter(password);

		Assert.assertThat(removedFirstCharacter, Matchers.equalTo(expected));

	}

	@Test
	public void shouldAssertStringWithOutLastCharacter() {

		String password = "abcdefg123";

		String expected = "abcdefg12";

		String removedLastCharacter = StringHelper.removeLastCharacter(password);

		Assert.assertThat(removedLastCharacter, Matchers.equalTo(expected));

	}

	@Test
	public void shouldAssertUpperCaseStringToLowerCase() {
		String password = "ABDS";

		String expected = "abds";

		String lowerCase = StringHelper.toLowerCase(password);

		Assert.assertThat(lowerCase, Matchers.equalTo(expected));
	}

}
