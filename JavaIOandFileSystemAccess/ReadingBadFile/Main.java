package ReadingBadFile;

import ReadingDataBase.Purchase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "purchases2.txt";

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {

            String first = br.readLine();
            int n;

            try {
                n = Integer.parseInt(first == null ? "" : first.trim());
            } catch (NumberFormatException e) {
                System.out.println("Список  пуст");
                return;
            }

            Purchase[] purchases = new Purchase[n];

            String bestName = null;
            int bestPrice = 0;
            double bestQty = 0.0;
            double minCost = Double.POSITIVE_INFINITY;

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line == null || line.isBlank()) {
                    purchases[i] = null;
                    continue;
                }

                String[] parts = line.split(";", -1);
                if (parts.length < 3) {
                    purchases[i] = null;
                    continue;
                }

                String name = parts[0].trim();
                String ps = parts[1].trim();
                String qs = parts[2].trim();

                if (name.isEmpty()) {
                    purchases[i] = null;
                    continue;
                }
                int price;
                double qty;
                try {
                    price = Integer.parseInt(ps);
                    qty = Double.parseDouble(qs);
                } catch (NumberFormatException e) {
                    purchases[i] = null;
                    continue;
                }

                if (price < 0 || qty < 0) {
                    purchases[i] = null;
                    continue;
                }

                Purchase p = new Purchase(name, price, qty);
                purchases[i] = p;

                double cost = price * qty;
                if (cost < minCost) {
                    minCost = cost;
                    bestName = name;
                    bestPrice = price;
                    bestQty = qty;
                }
            }

            if (bestName != null) {
                System.out.printf(Locale.US, "%s#%d#%.1f%n", bestName, bestPrice, bestQty);
            }

        } catch
        (IOException e) {
            System.out.println("Ошибка чтения" + e.getMessage());

            }
        }
    }