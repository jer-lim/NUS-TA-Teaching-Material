interface Loggable {
	public String getLogName();
}

abstract class MortalLife implements Loggable {}

abstract class Animal extends MortalLife {}

class Bear extends Animal {
	private static int nextId;
	private int id;

	public Bear() {
		id = nextId++;
	}

	@Override
	public String getLogName() {
		return "Bear" + this.id;
	}
}