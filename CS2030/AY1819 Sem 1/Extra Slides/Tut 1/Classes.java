class Plant {
	public void grow();
	public void die();
	public ArrayList<Plant> multiply();
}

class Animal {
	public void grow();
	public void die();
	public ArrayList<Animal> multiply();
}



class Life {
	public void grow();
	public void die();
}

class Plant extends Life {
	public ArrayList<Plant> multiply();
}

class Animal extends Life {
	public ArrayList<Animal> multiply();
}


class Life {
	public void grow();
	public void die();
	public ArrayList<Life> multiply();
}

class Plant extends Life {
}

class Animal extends Life {
}


class Plant extends Life {
}

class Animal extends Life {
	public void move();
}

class Tree extends Life {
	...
}

class Grass extends Life {
	...
}

class Animal extends Life {
	public void move();
}


class Life {
	public void grow();
	public void die();
	public ArrayList<Life> multiply();
}

class ImmortalLife extends Life {
	@override
	public void die() {
		// Do nothing
	}
}


class Life {
	public void grow();
	public ArrayList<Life> multiply();
}

class MortalLife extends Life {
	public void die();
}

class Log {
	String text;

	public static void log(String s) {
		...
	}
}

class Log {
	private static ArrayList<LogEvent> events;

	public static void log(LogEvent e) {
		...
	}

	public static String makeLog() {
		...
	}
}

class LogEvent {
	private Loggable subject;
	private String text;
}


class Main {
	public static void main(String[] args) {
		ArrayList<Plant> plants;
		ArrayList<Animal> animals;

		for (Plant p : plants) {
			...
		}
		for (Animal a : animals) {
			...
		}


		ArrayList<Life> life;

		for (Life l : life) {
			...
		}
	}
}


















