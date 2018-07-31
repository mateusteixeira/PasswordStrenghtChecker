package br.com.passwordstrenghtchecker.helper;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class AnalyzerHelperTest {

	private AnalyzerHelper analyzerHelper = new AnalyzerHelper() ;
	
	@Test
	public void shouldAssertTheNumberOfCharacters() {
		String password = "abc123";
		
		int expected = password.length();
		int passwordLenght = analyzerHelper.getPasswordLenght(password);
		
		Assert.assertThat(passwordLenght, equalTo(expected));
	}
	
	@Test
	public void shouldAssertTheNumberOfUpperCaseOccurrences() {
		
		String password = "ABCabc123D";
		
		int expected = 4;
		
		int upperCaseOccurrences = analyzerHelper.getUpperCaseOccurrences(password);
		
		Assert.assertThat(upperCaseOccurrences, equalTo(expected));
	}
	
	@Test
	public void shouldAssertTheNumberOfLowerCaseOccurrences() {
		
		String password = "ABCabc123D";
		
		int expected = 3;
		
		int lowerCaseOccurrences = analyzerHelper.getLowerCaseOccurrences(password);
		
		Assert.assertThat(lowerCaseOccurrences, equalTo(expected));
	}
	
	@Test
	public void shouldAssertTheOccurrencesOfNumbers() {
		
		String password = "ABCabc12345D";
		
		int expected = 5;
		
		int numberOccurrences = analyzerHelper.getNumberOccurrences(password);
		
		Assert.assertThat(numberOccurrences, equalTo(expected));
	}
	
	
	@Test
	public void shouldAssertTheNumberOfSymbolsOccurrences() {
		
		String password = "AB#Cabc12345D";
		
		int expected = 1;
		
		int symbolOccurrences = analyzerHelper.getSymbolOccurrences(password);
		
		Assert.assertThat(symbolOccurrences, equalTo(expected));
	}
	
	@Test
	public void shouldAssertTrueWhenOnlyLettersUpperCase() {
		
		String password = "ADD";
		
		Assert.assertTrue(analyzerHelper.isOnlyLetters(password));
		
	}
	
	@Test
	public void shouldAssertTrueWhenOnlyLettersLowerCase() {
		
		String password = "aer";
		
		Assert.assertTrue(analyzerHelper.isOnlyLetters(password));
		
	}
	
	@Test
	public void shouldAssertTrueWhenOnlyLettersLowerCaseAndUpperCase() {
		
		String password = "aerADS";
		
		Assert.assertTrue(analyzerHelper.isOnlyLetters(password));
		
	}
	
	@Test
	public void shouldAssertFalseWhenPasswordContainsNumber() {
		
		String password = "aerADS3";
		
		Assert.assertFalse(analyzerHelper.isOnlyLetters(password));
		
	}
	
	@Test
	public void shouldAssertFalseWhenPasswordContainsSymbols() {
		
		String password = "aerADS$";
		
		Assert.assertFalse(analyzerHelper.isOnlyLetters(password));
		
	}
	
	@Test
	public void shouldAssertTrueWhenOnlyNumbers() {
		
		String password = "342";
		
		Assert.assertTrue(analyzerHelper.isOnlyNumbers(password));
		
	}
	
	@Test
	public void shouldAssertFalseWhenContainsSymbols() {
		
		String password = "342%";
		
		Assert.assertFalse(analyzerHelper.isOnlyNumbers(password));
		
	}
	
	@Test
	public void shouldAssertTheNumberOfConsecutivesUpperCasesLetters() {
		
		String password = "ABDiwcDCD";
		
		int expected = 4;
		
		int consecutivesOccurrencesOfUpperCaseLetters = analyzerHelper.getConsecutivesOccurrencesOfUpperCaseLetters(password);
		
		Assert.assertThat(consecutivesOccurrencesOfUpperCaseLetters, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertTheNumberOfConsecutivesLowerCasesLetters() {
		
		String password = "ABDiwcDCD";
		
		int expected = 2;
		
		int consecutivesOccurrencesOfLowerCaseLetters = analyzerHelper.getConsecutivesOccurrencesOfLowerCaseLetters(password);
		
		Assert.assertThat(consecutivesOccurrencesOfLowerCaseLetters, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertTheNumberOfConsecutivesNumbers() {
		
		String password = "AB23Diw333cDCD222";
		
		int expected = 5;
		
		int consecutivesOccurrencesOfNumbers = analyzerHelper.getConsecutivesOccurrencesOfNumbers(password);
		
		Assert.assertThat(consecutivesOccurrencesOfNumbers, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertTheNumberOfOccurrenceOfSequencialLettersWhenMoreThanThreeWhenUpperCase() {
		
		String password = "ABCsdaDEF12GH";
		
		int expected = 2;
		
		int sequencialOccurrencesOfLetters = analyzerHelper.getSequencialOccurrencesOfLetters(password);
		
		Assert.assertThat(sequencialOccurrencesOfLetters, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertTheNumberOfOccurrenceOfSequencialLettersWhenMoreThanThreeWhenLowerCase() {
		
		String password = "ABCsdabcDEF12GH";
		
		int expected = 5;
		
		int sequencialOccurrencesOfLetters = analyzerHelper.getSequencialOccurrencesOfLetters(password);
		
		Assert.assertThat(sequencialOccurrencesOfLetters, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertTheNumberOfOccurrenceOfSequencialNumbersWhenMoreThanThree() {
		
		String password = "ABC123DEF124GH";
		
		int expected = 1;
		
		int sequencialOccurrencesOfNumbers = analyzerHelper.getSequencialOccurrencesOfNumbers(password);
		
		Assert.assertThat(sequencialOccurrencesOfNumbers, Matchers.equalTo(expected));
	}
	
	@Test
	public void shouldAssertTheNumberOfOccurrenceOfSequencialSymbolsWhenMoreThanThree() {
		
		String password = "ABC123DEF124GH;<=";
		
		int expected = 1;
		
		int sequencialOccurrencesOfSymbols = analyzerHelper.getSequencialOccurrencesOfSymbols(password);
		
		Assert.assertThat(sequencialOccurrencesOfSymbols, Matchers.equalTo(expected));
	}
	
}
