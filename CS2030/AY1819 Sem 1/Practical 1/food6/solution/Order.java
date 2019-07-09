import java.util.ArrayList;
import java.util.List;

class Order {
    private Menu menu;
    private List<Item> items;

    Order(Menu menu) {
        this.menu = menu;
        items = new ArrayList<>();
    }

    void add(int index) {
        items.add(menu.get(index));
    }

    @Override
    public String toString() {
        String s = "";
        int total = 0;
        for (Item item : items) {
            s = s + item.toString() + "\n";
            total += item.getPrice();
        }

        s = s + "Total: " + total;
        return s;
    }
}
