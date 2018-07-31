package br.com.passwordstrenghtchecker.rules;

import br.com.passwordstrenghtchecker.helper.AnalyzerHelper;
import br.com.passwordstrenghtchecker.rules.interfaces.DeductionRule;

public class RepeatCharacters implements DeductionRule {

	private AnalyzerHelper analyzerHelper = new AnalyzerHelper();

	/**
	 * Consultado o .js para implementação do algoritmo
	 * 
	 * **/
	@Override
	public int analyze(String password) {

		int passwordLenght = analyzerHelper.getPasswordLenght(password);

		int nRepChar = 0;
		int nUnqChar = 0;
		double nRepInc = 0;

		for (int i = 0; i < passwordLenght; i++) {

			boolean charExist = false;
			for (int j = 0; j < passwordLenght; j++) {
				if (password.charAt(i) == password.charAt(j) && i != j) {
					charExist = true;

					float div = (float) passwordLenght / (j - i);

					float abs = Math.abs(div);

					nRepInc += abs;

				}
			}

			if (charExist) {
				nRepChar++;
				nUnqChar = passwordLenght - nRepChar;

				if (nUnqChar > 0) {
					double aux = nRepInc / nUnqChar;
					nRepInc = Math.ceil(aux);
				} else {
					nRepInc = Math.ceil(nRepInc);
				}
			}
		}

		if (nRepChar > 0) {
			return (int) (nRepInc * getDeductionOperator());
		}
		return 0;
	}

}
