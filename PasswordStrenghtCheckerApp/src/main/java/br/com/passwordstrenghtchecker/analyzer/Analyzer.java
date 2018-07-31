package br.com.passwordstrenghtchecker.analyzer;

import br.com.passwordstrenghtchecker.enums.EnumAdditionRules;
import br.com.passwordstrenghtchecker.enums.EnumDeductionRules;
import br.com.passwordstrenghtchecker.rules.interfaces.AdditionRule;
import br.com.passwordstrenghtchecker.rules.interfaces.DeductionRule;

public class Analyzer {

	public int getScore(String password) {

		int score = getPositiveScore(password);

		score = score + getNegativeScore(password);
		
		return score;

	}

	private int getNegativeScore(String password) {
		int score = 0;

		EnumDeductionRules[] values = EnumDeductionRules.values();

		for (EnumDeductionRules enumDeductionRules : values) {

			DeductionRule deductionRule = enumDeductionRules.getInstance();

			score = score + deductionRule.analyze(password);
		}

		return score;
	}

	private int getPositiveScore(String password) {

		int score = 0;

		EnumAdditionRules[] values = EnumAdditionRules.values();

		for (EnumAdditionRules enumAdditionRules : values) {

			AdditionRule additionRule = enumAdditionRules.getInstance();

			score = score + additionRule.analyze(password);
		}

		return score;
	}
}
