package StandardInterfaces.Commodity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Commodity> listOther = new ArrayList<>();
        List<Commodity> listBelarus = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("end")) {
                break;
            }
            try {
                String[] parts = line.split("/");
                String name = parts[0];
                int price = Integer.parseInt(parts[1]);
                String country = parts[2];

                if (country.equalsIgnoreCase("Беларусь")) {
                    listBelarus.add(new Commodity(name, price, country));

                } else {
                    listOther.add(new Commodity(name, price, country));

                }

            } catch (Exception e) {
            }
        }

        listBelarus.sort(Comparator.comparing(Commodity::getName));
        listOther.sort(Comparator.comparing(Commodity::getPrice).reversed());

        if (listBelarus.isEmpty()) {
            System.out.println("Список товаров из Беларуси пуст");
        } else {
            for (Commodity c : listBelarus) {
                System.out.println(c);
            }
        }

        System.out.println();

        if (listOther.isEmpty()) {
            System.out.println("Список товаров из других стран пуст");
        } else {
            for (Commodity c : listOther) {
                System.out.println(c);
            }
        }

    }
}
