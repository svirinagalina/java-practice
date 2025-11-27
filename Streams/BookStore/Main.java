package Streams.BookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("end")) break;

            String[] parts = line.split(";");

            books.add(new Book(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2])));
        }

        Map<Integer, Book> map = books.stream()
                .collect(Collectors.toMap(
                        book -> book.getId(),
                        book -> book
                ));

        map.forEach((k, v) -> System.out.println(k + " = " + v));

    }


}
