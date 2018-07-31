package br.com.passwordstrenghtchecker.entity;

public class Complexity {

	private String description;
	private int min;
	private int max;

	public Complexity(String description, int min, int max) {
		this.description = description;
		this.min = min;
		this.max = max;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
