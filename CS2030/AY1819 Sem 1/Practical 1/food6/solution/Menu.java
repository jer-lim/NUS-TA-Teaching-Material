import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Item> items = new ArrayList<>();
    private List<Burger> burgers = new ArrayList<>();
    private List<Snack> snacks = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Combo> combos = new ArrayList<>();

    public void add(String type, String desc, int price) {
        if (type.equals("Burger")) {
            Burger item = new Burger(desc, price);
            burgers.add(item);
            items.add(item);
        } else if (type.equals("Snack")) {
            Snack item = new Snack(desc, price);
            snacks.add(item);
            items.add(item);
        } else if (type.equals("Drink")) {
            Drink item = new Drink(desc, price);
            drinks.add(item);
            items.add(item);
        }
    }

    public void add(String type, int burgerId, int snackId, int drinkId) {
        try {
            Combo item = new Combo((Burger)items.get(burgerId), (Snack)items.get(snackId), (Drink)items.get(drinkId));
            combos.add(item);
            items.add(item);
        } catch (IndexOutOfBoundsException | ClassCastException e) {
            System.err.println("Error: Invalid combo input " + 
                    burgerId + " " + snackId + " " + drinkId);
        }
    }

    public Item get(int index) {
        return items.get(index);
    }

    private void print(List<? extends Item> items) {
        for (Item i : items) {
            System.out.println(i);
        }
    }

    public void print() {
        print(burgers);
        print(snacks);
        print(drinks);
        print(combos);
    }
}
