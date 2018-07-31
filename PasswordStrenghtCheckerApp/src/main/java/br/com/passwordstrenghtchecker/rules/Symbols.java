package br.com.passwordstrenghtchecker.rules;

import br.com.passwordstrenghtchecker.helper.AnalyzerHelper;
import br.com.passwordstrenghtchecker.rules.interfaces.AdditionRule;

public class Symbols implements AdditionRule {

	private static final int MULTIPLE_CONSTANT = 6;

	private AnalyzerHelper analyzerHelper = new AnalyzerHelper();

	@Override
	public int analyze(String password) {

		int occurrences = analyzerHelper.getSymbolOccurrences(password);

		return occurrences * MULTIPLE_CONSTANT * getAdditionOperator();
	}

}
