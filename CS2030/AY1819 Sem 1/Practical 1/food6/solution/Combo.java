class Combo extends Item {
    private Burger burger;
    private Snack snack;
    private Drink drink;

    Combo(Burger burger, Snack snack, Drink drink) {
        this.burger = burger;
        this.snack = snack;
        this.drink = drink;
    }

    @Override
    int getPrice() {
        return burger.getPrice() + snack.getPrice() + drink.getPrice() - 50;
    }

    @Override
    public String toString() {
        return "#" + id + " Combo " + "(" + getPrice() + ")" +
            "\n   " + burger.toString() + "\n   " + snack.toString() + "\n   " + drink.toString();
    }
}
