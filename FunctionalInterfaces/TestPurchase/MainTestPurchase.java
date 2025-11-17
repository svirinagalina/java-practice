package FunctionalInterfaces.TestPurchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTestPurchase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<TestPurchasePurchase> list = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) break;

            String[] parts = line.split(";");
            list.add(new TestPurchasePurchase(parts[0],
                    Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2])
            ));
        }
        String filterName = scanner.nextLine();

        TestPurchases nameFilter = p -> p.getName().equals(filterName);

        List<TestPurchasePurchase> byName = list.stream().filter(nameFilter::test).toList();

        if (byName.isEmpty()) {
            System.out.println("ERROR");
        } else {
            byName.forEach(System.out::println);
        }

        System.out.println();

        TestPurchases costFilter = p -> p.getCost() >= 2000;

        List<TestPurchasePurchase> byCost = list.stream().filter(costFilter::test).toList();

        if (byCost.isEmpty()) {
            System.out.println("ERROR");
        } else {
            byCost.forEach(System.out::println);
        }

    }


}

