import java.util.*;

class Order {
	List<Food> items = new ArrayList<>();
	Menu menu;

	public Order(Menu menu) {
		this.menu = menu;
	}

	public void add(int id) {
		this.items.add(menu.find(id));
	}

	@Override
	public String toString() {
		String output = "--- Order ---\n";
		int total = 0;
		for (Food f : this.items) {
			output += f + "\n";
			total += f.getPrice();
		}
		output += "Total: " + total;
		return output;
	}
}