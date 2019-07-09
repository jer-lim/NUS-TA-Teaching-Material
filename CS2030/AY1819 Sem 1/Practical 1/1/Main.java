import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.next().equals("add")) {
            String type = sc.next();
            String desc = sc.next();
            int price = sc.nextInt();
            // System.out.println(type + " " + desc + " " + price);

            Food food;
            if (type.equals("Burger")) food = new Burger(desc, price);
            else if (type.equals("Snack")) food = new Snack(desc, price);
            else food = new Drink(desc, price);

            System.out.println(food);
        }
    }
}