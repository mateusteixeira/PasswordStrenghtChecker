package br.com.passwordstrenghtchecker.rules;

import br.com.passwordstrenghtchecker.helper.AnalyzerHelper;
import br.com.passwordstrenghtchecker.rules.interfaces.AdditionRule;

public class NumberCharacters implements AdditionRule {
	
	private static final int MULTIPLE_CONSTANT = 4;
	
	private AnalyzerHelper analyzerHelper = new AnalyzerHelper();
	
	
	@Override
	public int analyze(String password) {
		return analyzerHelper.getPasswordLenght(password) * MULTIPLE_CONSTANT * getAdditionOperator();
	}

}
