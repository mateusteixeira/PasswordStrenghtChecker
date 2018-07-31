package br.com.passwordstrenghtchecker.helper;


public class AnalyzerHelper {
	
    private static final String REGEX_UPPERCASE_LETTERS = "[A-Z]+";
    private static final String REGEX_LOWERCASE_LETTERS = "[a-z]+";
    private static final String REGEX_NUMBERS = "[0-9]+";
    private static final String REGEX_SYMBOLS = "[^a-zA-Z0-9\\s]";
    private static final String REGEX_ONLY_LETTERS = "[a-zA-Z]+";

	public int getPasswordLenght(String password) {
		return password.length();
	}

	public int getUpperCaseOccurrences(String password) {
		return getOccurrences(password, REGEX_UPPERCASE_LETTERS);
	}
	
	public int getLowerCaseOccurrences(String password) {
		return getOccurrences(password, REGEX_LOWERCASE_LETTERS);
	}
	
	public int getNumberOccurrences(String password) {
		return getOccurrences(password, REGEX_NUMBERS);
	}
	
	public int getSymbolOccurrences(String password) {
		return getOccurrences(password, REGEX_SYMBOLS);
	}
	
	public boolean isOnlyLetters(String password) {
		return password.matches(REGEX_ONLY_LETTERS);
	}
	
	public boolean isOnlyNumbers(String password) {
		return password.matches(REGEX_NUMBERS);
	}

	private int getConsecutivesOccurrences(String password, String regex) {
        Integer consecutivesOccurrences = 0;

		int passwordLenght = getPasswordLenght(password);
		
		for (int i = 0; i < passwordLenght - 1; i++) {
			
            if (String.valueOf(password.charAt(i)).matches(regex) && String.valueOf(password.charAt(i + 1)).matches(regex)) {
            	consecutivesOccurrences = consecutivesOccurrences + 1;
            }
        }
        return consecutivesOccurrences;
    }
	
	public int getConsecutivesOccurrencesOfUpperCaseLetters(String password) {
		return getConsecutivesOccurrences(password, REGEX_UPPERCASE_LETTERS);
	}
	
	public int getConsecutivesOccurrencesOfLowerCaseLetters(String password) {
		return getConsecutivesOccurrences(password, REGEX_LOWERCASE_LETTERS);
	}
	
	public int getConsecutivesOccurrencesOfNumbers(String password) {
		return getConsecutivesOccurrences(password, REGEX_NUMBERS);
	}
	
	private int getOccurrences(String password, String regex) {
		Integer matchFromRegex = 0;

		int passwordLenght = getPasswordLenght(password);
		
		for (int i = 0; i < passwordLenght; i++) {
		
			if (String.valueOf(password.charAt(i)).matches(regex)) {
				matchFromRegex++;
			}
			
		}
		return matchFromRegex;
	}
	
	private Integer getSequencialOccurrence(String password, String regex) {
		Integer sequencialOccurrence = 0;

		int passwordLenght = getPasswordLenght(password);

		for (int i = 0; i < passwordLenght - 1; i++) {

			if (isInLenghtRange(passwordLenght, i) && isSequencialCharacter(password, regex, i)) {
				sequencialOccurrence = sequencialOccurrence + 1;
			}

		}
		return sequencialOccurrence;
	}

	private boolean isInLenghtRange(int passwordLenght, int i) {
		return i + 2 < passwordLenght;
	}

    private boolean isSequencialCharacter(final String password, final String regex, final int i) {
       
    	int asciiCodeFirstChar = (int) password.charAt(i);
        
    	int asciiCodeSecondChar = (int) password.charAt(i + 1);
        
    	int asciiCodeThirdChar = (int) password.charAt(i + 2);

        return (asciiCodeFirstChar + 1 == asciiCodeSecondChar) && (asciiCodeSecondChar + 1 == asciiCodeThirdChar)
                && (String.valueOf(password.charAt(i)).matches(regex))
                && (String.valueOf(password.charAt(i + 1)).matches(regex))
                && (String.valueOf(password.charAt(i + 2)).matches(regex));
    }
	
    
    public int getSequencialOccurrencesOfLetters(String password) {
    	
    	password = StringHelper.toLowerCase(password);
    	
    	return getSequencialOccurrence(password, REGEX_ONLY_LETTERS);
    }

    public int getSequencialOccurrencesOfNumbers(String password) {
    	return getSequencialOccurrence(password, REGEX_NUMBERS);
    }
    
    public int getSequencialOccurrencesOfSymbols(String password) {
    	return getSequencialOccurrence(password, REGEX_SYMBOLS);
    }
    
}
