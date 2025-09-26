package Deserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String path = "massiv.ser";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Object object = ois.readObject();
            if (object instanceof double[] arr) {
                double average = Arrays.stream(arr).average().orElseThrow();

                System.out.printf("%.2f", average);
            } else {
                System.out.print("Ошибка");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
