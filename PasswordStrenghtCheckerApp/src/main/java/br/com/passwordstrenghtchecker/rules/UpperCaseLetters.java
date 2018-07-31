package br.com.passwordstrenghtchecker.rules;

import br.com.passwordstrenghtchecker.helper.AnalyzerHelper;
import br.com.passwordstrenghtchecker.rules.interfaces.AdditionRule;

public class UpperCaseLetters implements AdditionRule {
	
	private static final int MULTIPLE_CONSTANT = 2;

	private AnalyzerHelper analyzerHelper = new AnalyzerHelper();

	@Override
	public int analyze(String password) {

		int passwordLenght = analyzerHelper.getPasswordLenght(password);

		int score = 0;

		int occurrences = analyzerHelper.getUpperCaseOccurrences(password);

		if (occurrences > 0) {
			score = ((passwordLenght - occurrences) * MULTIPLE_CONSTANT);
		}

		return score;
	}

}
