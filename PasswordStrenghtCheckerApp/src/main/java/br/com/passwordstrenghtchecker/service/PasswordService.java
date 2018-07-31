package br.com.passwordstrenghtchecker.service;

import br.com.passwordstrenghtchecker.analyzer.Analyzer;
import br.com.passwordstrenghtchecker.analyzer.ComplexityGenerator;
import br.com.passwordstrenghtchecker.entity.Complexity;
import br.com.passwordstrenghtchecker.entity.Password;

public class PasswordService {


	private static final int MIN_SCORE = 0;
	private static final int MAX_SCORE = 100;
	
	
	public Password check(String password) {
		
		Analyzer analyzer = new Analyzer();
		
		int score = analyzer.getScore(password);

		score = adjusteScoreInTheRange(score);

		Complexity complexityFromPassword = getComplexityFromPassword(score);
		
		return new Password(password, score, complexityFromPassword.getDescription());
	}
	
	private Complexity getComplexityFromPassword(int score) {
		ComplexityGenerator complexityGenerator = new ComplexityGenerator();
		return complexityGenerator.generateComplexity(score);
	}
	
	private int adjusteScoreInTheRange(int score) {

		if(score > MAX_SCORE) {
			score = MAX_SCORE;
		}else if(score < MIN_SCORE) {
			score = MIN_SCORE;
		}
		
		return score;
	}

}
