package br.com.passwordstrenghtchecker.analyzer;

import br.com.passwordstrenghtchecker.entity.Complexity;
import br.com.passwordstrenghtchecker.enums.EnumComplexities;

public class ComplexityGenerator {

	public Complexity generateComplexity(int score) {
		EnumComplexities enumComplexities = EnumComplexities.getValue(score);
		
		return enumComplexities.getComplexity();
		
	}

	

	
}
