package StandardInterfaces.Abiturient;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Abiturient> list = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("end")) {
                break;
            }

            try {
                String[] parts = line.split("#");
                if (parts.length != 5) {
                    continue;
                }
                String surname = parts[0];
                String name = parts[1];
                int mark1 = Integer.parseInt(parts[2]);
                int mark2 = Integer.parseInt(parts[3]);
                int mark3 = Integer.parseInt(parts[4]);

                list.add(new Abiturient(surname, name, mark1, mark2, mark3));
            } catch (Exception e) {
            }
        }

        if (list.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }

        list.sort(
                Comparator.comparing(Abiturient::getSurname)
                .thenComparing(Abiturient::getName)
);

        for (
                Abiturient a : list) {
            System.out.println(a);
        }

        System.out.println();

        list.sort(Comparator.comparingDouble(Abiturient::average)

                .reversed());

        for (
                Abiturient a : list) {
            System.out.println(a);
        }
    }
}
