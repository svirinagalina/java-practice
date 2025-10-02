package ReadingDataBase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;


public class Main {
    public static void main(String[] args) throws IOException {
        String path = "purchases.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            int n = Integer.parseInt(br.readLine().trim());
            Purchase[] purchase = new Purchase[n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                String[] parts = line.split(";");
                String name = parts[0];
                int price = Integer.parseInt(parts[1].trim());
                double qty = Double.parseDouble(parts[2].trim().replace(',', '.'));
                purchase[i] = new Purchase(name, price, qty);
            }

            int minPrice = 0;
            for (int i = 0; i < purchase.length; i++) {
                if (purchase[i].cost() < purchase[minPrice].cost()) {
                    minPrice = i;
                }
            }
            Purchase p = purchase[minPrice];
            System.out.printf(Locale.US, "%s#%d#%.1f%n", p.name, p.price, p.qty);

        } catch (IOException e) {
            System.err.println("Ошибка чтения: " + e.getMessage());

        }
    }
}
