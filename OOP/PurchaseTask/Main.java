import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        try {
            n = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ERROR");
            return;
        }

        if (n < 0) {
            System.out.println("ERROR");
            return;
        }

        Purchase[] purchases = new Purchase[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("ERROR");
                return;
            }

            String[] parts = line.split("\\s+");
            if (parts.length < 3) {
                System.out.println("ERROR");
                return;
            }

            String name = parts[0];
            int price = Integer.parseInt(parts[1]);
            int quantity = Integer.parseInt(parts[2]);

            Commodity commodity = new Commodity(name, price);
            purchases[i] = new Purchase(commodity, quantity);
        }

        int maxCost = 0;
        for (Purchase purchase : purchases) {
            int cost = purchase.getCost();
            if (cost > maxCost) {
                maxCost = cost;
            }
        }

        for (Purchase purchase : purchases) {
            if (purchase.getCost() == maxCost) {
                System.out.println(purchase);
            }
        }
    }
}
