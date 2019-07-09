public class Food {

	private static int newId = 0; // Id starts from 0

	protected int id;
	protected String name;
	protected int price; // Price is in cents

	public Food(String name, int price) {
		this.id = newId++;
		this.name = name;
		this.price = price;
	}

	public boolean hasId(int id) {
		return this.id == id;
	}

	public int getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return "#" + this.id + " " + this.getClass().getName() + ": "
				+ this.name + " (" + this.price + ")";
	}
}