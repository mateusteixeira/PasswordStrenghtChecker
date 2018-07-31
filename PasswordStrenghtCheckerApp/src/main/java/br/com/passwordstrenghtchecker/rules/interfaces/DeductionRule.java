package br.com.passwordstrenghtchecker.rules.interfaces;

public interface DeductionRule extends Rule{
	
	public default int getDeductionOperator() {
		return -1;
	}

}
