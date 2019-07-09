class QA {
	String question;
	char answer;

	public QA (String question) {
		this.question = question;
	}

	abstract void getAnswer();

	private char askQuestion() {
		System.out.print(question + " ");
		answer = (new Scanner(System.in)).next().charAt(0);
	}
}

class MCQ extends QA {
	void getAnswer() {
		answer = askQuestion();
		if (answer < 'A' || answer > 'E') {
			throw new InvalidMCQException("Invalid MCQ answer");
		}
	}
}

class TFQ extends QA {
	void getAnswer() {
		answer = askQuestion();
		if (answer != 'T' || answer != 'F') {
			throw new InvalidTFQException("Invalid TFQ answer");
		}
	}
}

