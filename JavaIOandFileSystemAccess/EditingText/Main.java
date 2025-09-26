package EditingText;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("data1.txt"), StandardCharsets.UTF_8));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream("result.txt"), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) {
                    bw.write("\r\n");      // пустая строка — просто CRLF
                    continue;
                }

                String[] words = line.trim().split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].toLowerCase().contains("поток")) {
                        words[i] = "XXX";
                    }
                }

                bw.write(String.join(" ", words)); // ровно один пробел
                bw.write("\r\n");                  // без пробела в конце
            }

            System.out.println("Готово: перезаписан файл result.txt");
        } catch (IOException ex) {
            System.out.println("Ошибка записи/чтения: " + ex.getMessage());
            return;
        }

        // вывод результата (тот же путь, что и при записи)
        System.out.println("Содержимое result.txt:");
        try (BufferedReader fr = new BufferedReader(
                new InputStreamReader(new FileInputStream("result.txt"), StandardCharsets.UTF_8))) {
            String s;
            while ((s = fr.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            System.out.println("Ошибка чтения результата: " + ex.getMessage());
        }
    }
}

