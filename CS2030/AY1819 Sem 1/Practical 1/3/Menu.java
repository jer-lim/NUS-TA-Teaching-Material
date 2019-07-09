import java.util.*;

public class Menu {
	private List<Burger> burgers = new ArrayList<>();
	private List<Snack> snacks = new ArrayList<>();
	private List<Drink> drinks = new ArrayList<>();
	private List<Food> allFood = new ArrayList<>();

	public void add(Burger b) {
		this.burgers.add(b);
		this.allFood.add(b);
	}

	public void add(Snack s) {
		this.snacks.add(s);
		this.allFood.add(s);
	}

	public void add(Drink d) {
		this.drinks.add(d);
		this.allFood.add(d);
	}

	public Food find(int id) {
		for(Food f : this.allFood) {
			if (f.hasId(id)) {
				return f;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String output = "";
		for (Food f : this.burgers) {
			output += f + "\n";
		}

		for (Food f : this.snacks) {
			output += f + "\n";
		}

		for (Food f : this.drinks) {
			output += f + "\n";
		}
		return output.trim(); // Fix trailing newline
	}
}

