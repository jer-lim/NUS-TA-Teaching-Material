class Car {
	int horsepower;
	double weight;
	String make; // or brand
	String model;
	double hpToWeightRatio;

	public Car(int hp, double w, String make, String model) {
		this.horsepower = hp;
		this.weight = w;
		this.make = make;
		this.model = model;
		this.hpToWeightRatio = hp/w;
	}

	public Car race(Car other) {
		if (this.hpToWeightRatio > other.hpToWeightRatio) {
			return this;
		} else {
			return other;
		}
	}

	@Override
	public String toString() {
		return "The " + this.make + " " + this.model + " has " + this.horsepower
			+ "hp and weighs " + this.weight + "kg.";
	}
}

public class ImpToOopSolution {
	public static void main(String[] args) {
		Car mazda = new Car(181, 1112.66, "Mazda", "MX-5");
		Car subaru = new Car(205, 1269.15, "Subaru", "BRZ");

		System.out.println(mazda);
		System.out.println(subaru);

		Car winner = mazda.race(subaru);
		System.out.println("In a race, the " + winner.make + " will probably win.");
	}
}

