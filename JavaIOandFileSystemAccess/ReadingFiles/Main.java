package ReadingFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        int equalCount = 0;
        try (InputStream in1 = new FileInputStream("data.dat");
             InputStream in2 = new FileInputStream("promo.dat")) {
            int a, b;
            while (true) {
                a = in1.read();
                b = in2.read();
                if (a == -1 || b == -1) break;
                if (a == b) equalCount++;
            }
            System.out.println(equalCount);
        } catch (IOException e) {
            System.out.println("Ошибка " + e.getMessage());
        }
    }
}
