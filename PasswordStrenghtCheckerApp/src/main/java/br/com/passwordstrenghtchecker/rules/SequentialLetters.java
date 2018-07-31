package br.com.passwordstrenghtchecker.rules;

import br.com.passwordstrenghtchecker.helper.AnalyzerHelper;
import br.com.passwordstrenghtchecker.rules.interfaces.DeductionRule;

public class SequentialLetters implements DeductionRule {

	private static final int MULTIPLE_CONSTANT = 3;
	
	private AnalyzerHelper analyzerHelper = new AnalyzerHelper();
	
	@Override
	public int analyze(String password) {

		int sequencialOccurrencesOfLetters = analyzerHelper.getSequencialOccurrencesOfLetters(password);
		
		return sequencialOccurrencesOfLetters * MULTIPLE_CONSTANT * getDeductionOperator();
	}
	
}
