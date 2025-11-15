package FunctionalInterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class FunctionalMain {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
List<PurchaseFunctional> list = new ArrayList<>();

while(true) {
    String line = scanner.nextLine();
    if (line.equals("end")) break;

    String[] parts = line.split(";");
    list.add(new PurchaseFunctional(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
    }

Collections.sort(list, (a, b) -> a.getName().compareTo(b.getName()));

list.forEach(System.out::println);
}
}
