package ReadingArray;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (DataInputStream input = new DataInputStream(new FileInputStream("array.dat"))) {
            int size = input.readInt();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                int number = input.readInt();
                sum += number;
            }
            double average = (double) sum / size;
            System.out.printf("%.1f", average);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
