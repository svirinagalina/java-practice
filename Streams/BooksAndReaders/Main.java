package Streams.BooksAndReaders;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Reader> readers = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equals("end")) {
                break;
            }

            String[] parts = line.split("\\s+");
            String surname = parts[0];
            int n = Integer.parseInt(parts[1]);

            Reader reader = new Reader(surname);

            for (int i = 0; i < n; i++) {
                String bookLine = scanner.nextLine();
                String[] b = bookLine.split(";");

                int number = Integer.parseInt(b[0]);
                String author = b[1];
                String title = b[2];
                reader.addBook(new Book(number, author, title));
            }
            readers.add(reader);
        }
                ArrayList<Book> allBooks = new ArrayList<>();

                for (Reader r : readers) {
                    allBooks.addAll(r.getBooks());
                }
                allBooks.stream()
                        .sorted(Comparator.comparingInt(Book::getNumber))
                        .forEach(System.out::println);
            }

        }
