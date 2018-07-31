package br.com.passwordstrenghtchecker.rules;

import br.com.passwordstrenghtchecker.helper.AnalyzerHelper;
import br.com.passwordstrenghtchecker.rules.interfaces.AdditionRule;

public class Requirements implements AdditionRule {

	private static final int MULTIPLE_CONSTANT = 2;

	private AnalyzerHelper analyzerHelper = new AnalyzerHelper();

	@Override
	public int analyze(String password) {

		int rulesReached = 0;

		if (hasUppercase(password)) {
			rulesReached = rulesReached + 1;
		}

		if (hasLowercase(password)) {
			rulesReached = rulesReached + 1;
		}

		if (hasNumbers(password)) {
			rulesReached = rulesReached + 1;
		}

		if (hasSymbols(password)) {
			rulesReached = rulesReached + 1;
		}

		if (moreThanTwoRulesReached(rulesReached) && isMoreOrEqualEightCharacters(password)) {

			rulesReached = rulesReached + 1;

			return applyRule(rulesReached);
		}

		return 0;
	}

	private int applyRule(int rulesReached) {
		return rulesReached * MULTIPLE_CONSTANT * getAdditionOperator();
	}

	private boolean isMoreOrEqualEightCharacters(String password) {
		return analyzerHelper.getPasswordLenght(password) >= 8;
	}

	private boolean moreThanTwoRulesReached(int rulesReached) {
		return rulesReached >= 3;
	}

	private boolean hasSymbols(String password) {
		return analyzerHelper.getSymbolOccurrences(password) > 0;
	}

	private boolean hasNumbers(String password) {
		return analyzerHelper.getNumberOccurrences(password) > 0;
	}

	private boolean hasLowercase(String password) {
		return analyzerHelper.getLowerCaseOccurrences(password) > 0;
	}

	private boolean hasUppercase(String password) {
		return analyzerHelper.getUpperCaseOccurrences(password) > 0;
	}

}
