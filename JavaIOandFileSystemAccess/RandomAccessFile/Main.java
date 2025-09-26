package RandomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        String path = "my.bin"; // положи файл в корень проекта или укажи полный путь

        try (RandomAccessFile raf = new RandomAccessFile(path, "r")) {
            // первый double
            raf.seek(0);
            double first = raf.readDouble();

            // последний double (универсально: прыжок в конец минус 8 байт)
            long lastPos = raf.length() - Double.BYTES; // Double.BYTES == 8
            raf.seek(lastPos);
            double last = raf.readDouble();

            double sum = first + last;

            // округление до 3 знаков по правилам HALF_UP
            BigDecimal out = BigDecimal.valueOf(sum).setScale(3, RoundingMode.HALF_UP);
            System.out.println(out.toPlainString());
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
