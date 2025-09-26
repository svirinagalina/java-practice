package ReadingBytes;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main (String[] args) {
        int count = 0;
        try (FileInputStream in = new FileInputStream("info.dat")){
            int b;
            while ((b = in.read()) != -1) {
                if (b >= 50 && b <= 100 ) {
                    count++;
                }
            }
            System.out.println("Количетво байт в диапазоне 50-100: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
