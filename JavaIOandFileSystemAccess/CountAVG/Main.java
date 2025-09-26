package CountAVG;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String path = "data3.txt"; // положи сюда свой файл или измени путь
        double sum = 0.0;
        int count = 0;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] tokens = line.trim().split("\\s+");

                for (String t : tokens) {
                    // числа вида: 12, -3, 4.5, .75, -10., +0.25
                    if (t.matches("[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)")) {
                        sum += Double.parseDouble(t);
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
            return;
        }

        if (count == 0) {
            System.out.println("0.00"); // на всякий случай
        } else {
            System.out.printf(Locale.US, "%.2f%n", sum / count);
        }
    }
}
