package br.com.passwordstrenghtchecker.rules;

import br.com.passwordstrenghtchecker.helper.AnalyzerHelper;
import br.com.passwordstrenghtchecker.rules.interfaces.AdditionRule;

public class Numbers implements AdditionRule {
	
	private static final int MULTIPLE_CONSTANT = 4;
	
	private AnalyzerHelper analyzerHelper = new AnalyzerHelper();

	@Override
	public int analyze(String password) {

		int occurrences = analyzerHelper.getNumberOccurrences(password);
		
		return occurrences * MULTIPLE_CONSTANT;
	}

}
