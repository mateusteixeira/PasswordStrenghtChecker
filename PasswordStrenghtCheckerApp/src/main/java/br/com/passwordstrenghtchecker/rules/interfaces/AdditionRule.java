package br.com.passwordstrenghtchecker.rules.interfaces;


public interface AdditionRule extends Rule {
	
	public default int getAdditionOperator() {
		return 1;
	}

}
