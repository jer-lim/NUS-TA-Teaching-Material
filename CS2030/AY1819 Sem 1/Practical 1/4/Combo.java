class Combo extends Food {

	Burger burger;
	Snack snack;
	Drink drink;

	public Combo(Menu menu, int burgerId, int snackId, int drinkId) {
		super("Combo", 0);
		this.burger = (Burger)menu.find(burgerId);
		this.snack = (Snack)menu.find(snackId);
		this.drink = (Drink)menu.find(drinkId);

		this.price = this.burger.getPrice() + this.snack.getPrice() + this.drink.getPrice() - 50;
	}

	@Override
	public String toString() {
		String output = "";
		output = "#" + this.id + " Combo (" + this.price + ")\n";
		output += "   " + this.burger + "\n";
		output += "   " + this.snack + "\n";
		output += "   " + this.drink;
		return output;
	}
}