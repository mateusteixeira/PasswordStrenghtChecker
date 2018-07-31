package br.com.passwordstrenghtchecker.enums;

import java.lang.reflect.InvocationTargetException;

import br.com.passwordstrenghtchecker.rules.ConsecutiveLowerCaseLetters;
import br.com.passwordstrenghtchecker.rules.ConsecutiveNumbers;
import br.com.passwordstrenghtchecker.rules.ConsecutiveUpperCaseLetters;
import br.com.passwordstrenghtchecker.rules.LettersOnly;
import br.com.passwordstrenghtchecker.rules.NumbersOnly;
import br.com.passwordstrenghtchecker.rules.RepeatCharacters;
import br.com.passwordstrenghtchecker.rules.SequentialLetters;
import br.com.passwordstrenghtchecker.rules.SequentialNumbers;
import br.com.passwordstrenghtchecker.rules.SequentialSymbols;
import br.com.passwordstrenghtchecker.rules.interfaces.DeductionRule;

public enum EnumDeductionRules {

	LETTERS_ONLY(LettersOnly.class),
	NUMBERS_ONLY(NumbersOnly.class), 
	REPEAT_CHARACTERES(RepeatCharacters.class),
	CONSECUTIVE_UPPERCASE_LETTERS(ConsecutiveUpperCaseLetters.class),
	CONSECUTIVE_LOWERCASE_LETTERS(ConsecutiveLowerCaseLetters.class),
	CONSECUTIVE_NUMBERS(ConsecutiveNumbers.class),
	SEQUENTIAL_LETTERS(SequentialLetters.class),
	SEQUENTIAL_NUMBERS(SequentialNumbers.class),
	SEQUENTIAL_SYMBOLS(SequentialSymbols.class)
	
	;
	
	private Class<? extends DeductionRule> deductionRule;

	
	private EnumDeductionRules(Class<? extends DeductionRule> deductionRule) {
		this.deductionRule = deductionRule;
	}


	public DeductionRule getInstance() {
		try {
			return deductionRule.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
