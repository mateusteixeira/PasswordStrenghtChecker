package br.com.passwordstrenghtchecker.rules;

import br.com.passwordstrenghtchecker.helper.AnalyzerHelper;
import br.com.passwordstrenghtchecker.rules.interfaces.DeductionRule;

public class ConsecutiveLowerCaseLetters implements DeductionRule {

	private static final int MULTIPLE_CONSTANT = 2;
	
	private AnalyzerHelper analyzerHelper = new AnalyzerHelper();
	
	@Override
	public int analyze(String password) {

		int consecutivesOccurrencesOfLowerCaseLetters = analyzerHelper.getConsecutivesOccurrencesOfLowerCaseLetters(password);
		
		return consecutivesOccurrencesOfLowerCaseLetters * MULTIPLE_CONSTANT * getDeductionOperator();
	}

}
