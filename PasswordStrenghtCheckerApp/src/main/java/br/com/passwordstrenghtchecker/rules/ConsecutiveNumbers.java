package br.com.passwordstrenghtchecker.rules;

import br.com.passwordstrenghtchecker.helper.AnalyzerHelper;
import br.com.passwordstrenghtchecker.rules.interfaces.DeductionRule;

public class ConsecutiveNumbers implements DeductionRule {

	private static final int MULTIPLE_CONSTANT = 2;
	
	private AnalyzerHelper analyzerHelper = new AnalyzerHelper();
	
	@Override
	public int analyze(String password) {

		int consecutivesOccurrencesOfNumbers = analyzerHelper.getConsecutivesOccurrencesOfNumbers(password);
		
		return consecutivesOccurrencesOfNumbers * MULTIPLE_CONSTANT * getDeductionOperator();
	}
	

}
