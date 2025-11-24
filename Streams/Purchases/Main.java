package Streams.Purchases;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Purchase> purchases = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) break;


            String[] tokens = line.split(" ");
            String cardNumber = tokens[0];
            int n = Integer.parseInt(tokens[1]);


            Purchase purchase = new Purchase(cardNumber);

            for (int i = 0; i < n; i++) {
                String[] itemTokens = scanner.nextLine().split(" ");
                String name = itemTokens[0];
                int price = Integer.parseInt(itemTokens[1]);
                double count = Double.parseDouble(itemTokens[2]);

                purchase.addItem(new Commodity(name, price), count);
            }
purchases.add(purchase);
        }

            Set<Commodity> allCommodities = purchases.stream()
                    .flatMap(purchase -> purchase.getItems().keySet().stream())
                    .collect(Collectors.toSet());

            allCommodities.stream()
                    .sorted(Comparator.comparing(Commodity::getName))
                    .forEach(System.out::println);
        }
    }

