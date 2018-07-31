package br.com.passwordstrenghtchecker.enums;

import java.lang.reflect.InvocationTargetException;

import br.com.passwordstrenghtchecker.rules.LowerCaseLetters;
import br.com.passwordstrenghtchecker.rules.MiddleNumberSymbol;
import br.com.passwordstrenghtchecker.rules.NumberCharacters;
import br.com.passwordstrenghtchecker.rules.Numbers;
import br.com.passwordstrenghtchecker.rules.Requirements;
import br.com.passwordstrenghtchecker.rules.Symbols;
import br.com.passwordstrenghtchecker.rules.UpperCaseLetters;
import br.com.passwordstrenghtchecker.rules.interfaces.AdditionRule;

public enum EnumAdditionRules {
	
	NUMBER_OF_CHARACTERS(NumberCharacters.class),
	UPPERCASE_LETTERS(UpperCaseLetters.class),
	LOWERCASE_LETTERS(LowerCaseLetters.class),
	NUMBERS(Numbers.class),
	SYMBOLS(Symbols.class),
	MIDDLE_NUMBERS_SYMBOLS(MiddleNumberSymbol.class),
	REQUIREMENTS(Requirements.class)
	;
	
	
	private EnumAdditionRules(Class<? extends AdditionRule> additionRule) {
		this.additionRule = additionRule;
	}

	private Class<? extends AdditionRule> additionRule;

	public AdditionRule getInstance() {
		try {
			return additionRule.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}
}
