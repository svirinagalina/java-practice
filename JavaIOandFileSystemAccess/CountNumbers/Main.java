package CountNumbers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main (String[] args) {
        int digits = 0;

        try (InputStream in = new FileInputStream("data2.txt")) {
            int b;
            while ((b = in.read()) != -1) {
                if (b >= '0' && b <= '9')
                digits++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка" + e.getMessage());
            return;
        }

        System.out.println(digits);
    }
}
