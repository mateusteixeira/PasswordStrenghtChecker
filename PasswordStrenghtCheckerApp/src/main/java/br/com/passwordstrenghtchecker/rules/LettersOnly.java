package br.com.passwordstrenghtchecker.rules;

import br.com.passwordstrenghtchecker.helper.AnalyzerHelper;
import br.com.passwordstrenghtchecker.rules.interfaces.DeductionRule;

public class LettersOnly implements DeductionRule {
	
	private AnalyzerHelper analyzerHelper = new AnalyzerHelper();
	
	@Override
	public int analyze(String password) {

		int passwordLenght = 0;
		
		if(analyzerHelper.isOnlyLetters(password)) {
			passwordLenght = analyzerHelper.getPasswordLenght(password);
		}
		
		return passwordLenght * getDeductionOperator();
	}
	

}
