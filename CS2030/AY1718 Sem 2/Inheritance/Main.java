class Animal {
	public void move() {
		System.out.println("roll roll");
	}
}

class Cat extends Animal {
	public void move() {
		System.out.println("walk walk");
	}
}

class Kangaroo extends Animal {
	public void move() {
		System.out.println("hop hop");
	}
}

public class Main {
	public static void main(String[] args) {
		Animal[] animals = new Animal[3];
		animals[0] = new Animal();
		animals[1] = new Cat();
		animals[2] = new Kangaroo();

		for (int i = 0; i < 3; ++i) {
			animals[i].move();
			// roll roll
			// walk walk
			// hop hop
		}
	}
}