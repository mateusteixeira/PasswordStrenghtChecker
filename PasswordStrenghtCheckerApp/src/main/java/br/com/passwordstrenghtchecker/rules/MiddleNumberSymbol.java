package br.com.passwordstrenghtchecker.rules;

import br.com.passwordstrenghtchecker.helper.AnalyzerHelper;
import br.com.passwordstrenghtchecker.helper.StringHelper;
import br.com.passwordstrenghtchecker.rules.interfaces.AdditionRule;

public class MiddleNumberSymbol implements AdditionRule {
	
	private static final int MULTIPLE_CONSTANT = 2;

	private AnalyzerHelper analyzerHelper = new AnalyzerHelper();

	@Override
	public int analyze(String password) {

		int passwordLenght = analyzerHelper.getPasswordLenght(password);

		if (passwordLenght > 3) {

			String preparedPasswordForAnalyze = preparePasswordForAnalyze(password);

			int symbolOccurrences = analyzerHelper.getSymbolOccurrences(preparedPasswordForAnalyze);

			int numberOccurrences = analyzerHelper.getNumberOccurrences(preparedPasswordForAnalyze);

			return applyRule(symbolOccurrences, numberOccurrences);

		}

		return 0;
	}

	private int applyRule(int symbolOccurrences, int numberOccurrences) {
		return (symbolOccurrences + numberOccurrences) * MULTIPLE_CONSTANT;
	}

	private String preparePasswordForAnalyze(String password) {
		password = StringHelper.removeFirstCharacter(password);
		return StringHelper.removeLastCharacter(password);
	}

}
