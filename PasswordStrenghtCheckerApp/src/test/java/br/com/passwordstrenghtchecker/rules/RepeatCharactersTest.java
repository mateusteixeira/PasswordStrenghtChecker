package br.com.passwordstrenghtchecker.rules;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class RepeatCharactersTest {

	private RepeatCharacters repeatCharacters = new RepeatCharacters();
	
	@Test
	public void shouldAssertExpectedValue() {
		
		int expected = - 9;
		
		int evaluation = repeatCharacters.analyze("absbaAaaab##");
	
		Assert.assertThat(evaluation, Matchers.equalTo(expected));
	}

}
