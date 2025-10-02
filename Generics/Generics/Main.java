package Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        String buffer = scanner.next();

        while (!"finish".equals(buffer)) {
            try {
                int number = Integer.parseInt(buffer);

                if (number >= 0) {
                    positive.add(number);
                } else {
                    negative.add(number);
                }

            } catch (NumberFormatException e) {
                positive.add(0);
            }
            buffer = scanner.next();
        }
        Collections.sort(positive);
        Collections.sort(negative);
        if (positive.isEmpty()) {
            System.out.println("Пустой список");
        }
        for (Integer i : positive) {
            System.out.print(i + " ");
        }
        System.out.println();
        if (negative.isEmpty()) {
            System.out.print("Пустой список");
        }
        for (Integer i : negative) {
            System.out.print(i + " ");
        }
    }

}