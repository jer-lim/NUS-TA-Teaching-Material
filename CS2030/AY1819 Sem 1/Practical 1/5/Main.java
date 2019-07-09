import java.util.*;

class Main {
    public static void main(String[] args) {
    	Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        while(sc.next().equals("add")) {
            String type = sc.next();

            // In hindsight combo creation should be in Menu
            if (type.equals("Combo")) {
            	int burgerId = sc.nextInt();
        		int snackId = sc.nextInt();
        		int drinkId = sc.nextInt();
            	try {
	            	Combo c = new Combo(menu, burgerId, snackId, drinkId);
	            	menu.add(c);
	            } catch (NoSuchElementException | ClassCastException ex) {
	            	System.out.println("Error: Invalid combo input " + burgerId + " " + snackId + " " + drinkId);
	            }
            } else {
            	String desc = sc.next();
            	int price = sc.nextInt();
	            if (type.equals("Burger")) {
	            	Burger b = new Burger(desc, price);
	            	menu.add(b);
	            } else if (type.equals("Snack")) {
	            	Snack s = new Snack(desc, price);
	            	menu.add(s);
	            } else {
	            	Drink d = new Drink(desc, price);
	            	menu.add(d);
	            }
	        }
        }

        System.out.println(menu);

        // read order
        Order order = new Order(menu);
        while (sc.hasNext()) {
        	order.add(sc.nextInt());
        }

        System.out.println(order);
    }
}