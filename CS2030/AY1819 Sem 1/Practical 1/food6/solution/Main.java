import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        while(sc.next().equals("add")) {
            String type = sc.next();
            if (type.equals("Combo")) {
                menu.add(type, sc.nextInt(), sc.nextInt(), sc.nextInt());
            } else {
                menu.add(type, sc.next(), sc.nextInt());
            }
        }
        menu.print();

        Order order = new Order(menu);
        while (sc.hasNext()) {
            order.add(sc.nextInt());
        }
        System.out.println("--- Order ---");
        System.out.println(order);
    }
}
