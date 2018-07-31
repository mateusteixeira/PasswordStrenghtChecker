package br.com.passwordstrenghtchecker.enums;

import br.com.passwordstrenghtchecker.entity.Complexity;

public enum EnumComplexities {

	TOO_SHORT(new Complexity("Too Short", 0, 0)),
	VERY_WEAK(new Complexity("Very Weak", 1, 20)),
	WEAK(new Complexity("Weak", 21, 40)),
	GOOD(new Complexity("Good", 41, 60)),
	STRONG(new Complexity("Strong", 61, 80)),
	VERY_STRONG(new Complexity("Very Strong", 81, 100))
	
	;
	
	private Complexity complexity;
	
	private EnumComplexities(Complexity complexity) {
		this.complexity = complexity;
	}

	public static EnumComplexities getValue(int score) {
		
		EnumComplexities[] values = values();
		
		for (EnumComplexities enumComplexities : values) {
			
			if(score >= enumComplexities.getComplexity().getMin() && score <= enumComplexities.getComplexity().getMax()) {
				return enumComplexities;
			}
		}
		
		
		throw new RuntimeException("Não foi achado faixa de complexidade para o score: "+score);
	}

	public Complexity getComplexity() {
		return complexity;
	}
	
}
