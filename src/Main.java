import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int n = Integer.parseInt(firstLine.trim());

        if (n < 0) {
            System.out.println("ERROR");
            return;
        }

        Purchase[] items = new Purchase[n];

        for (int i = 0; i < items.length; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String name = parts[0];
            int price = Integer.parseInt(parts[1]);
            int quantity = Integer.parseInt(parts[2]);

            Commodity commodity = new Commodity(name, price);
            items[i] = new Purchase(commodity, quantity);
        }

        int max = 0;
        for (Purchase p : items) {
            if (p.getCost() > max) {
                max = p.getCost();
            }
        }

        for (Purchase p : items) {
            if (p.getCost() == max) {
                System.out.println(p);
            }
        }

        //put your code here
    }
}