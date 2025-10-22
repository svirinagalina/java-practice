package DataStructures;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Purchases> purchases = new HashSet<>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) break;

            String[] parts = line.split("#");
            String name = parts[0];
            String country = parts[1];
            Double price = Double.parseDouble(parts[2]);

            purchases.add(new Purchases(name, country, price));
        }

        List<Purchases> sorted = new ArrayList<>(purchases);
        sorted.sort(Comparator
                .comparing(Purchases::getName)
                .thenComparingDouble(Purchases::getPrice)
        );
        for (Purchases p : sorted) {
            System.out.println(p.getName() + ";" + p.getPrice());

        }


    }


}

