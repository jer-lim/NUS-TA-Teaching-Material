import java.util.*;

class Main {
    public static void main(String[] args) {
    	Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        while(sc.next().equals("add")) {
            String type = sc.next();

            if (type.equals("Combo")) {
            	Combo c = new Combo(menu, sc.nextInt(), sc.nextInt(), sc.nextInt());
            	menu.add(c);
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