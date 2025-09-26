package ReadingNumbers;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        double sum = 0;

        try (DataInputStream input = new DataInputStream(new FileInputStream("numbers.info"))) {

            for (int i = 0; i < 35; i++) {
                double number = input.readDouble();
                sum += number;
            }
            System.out.printf("%.2f", sum);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
