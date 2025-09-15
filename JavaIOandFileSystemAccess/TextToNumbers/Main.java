package TextToNumbers;

import java.io.*;

import java.nio.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0;

        while(scanner.hasNext()) {
            String token = scanner.next();
            try {
                double value = Double.parseDouble(token);
                sum += value;
            } catch (NumberFormatException e){

            }
        }
        System.out.printf("%.6f%n", sum);
    }

}
