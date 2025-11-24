package Streams.BooksAndReaders;

import java.util.ArrayList;
import java.util.List;

class Reader {
private String surname;

List<Book> books = new ArrayList<>();

public Reader(String surname) {
    this.surname = surname;
}

public void addBook(Book book) {
    books.add(book);
}

public List<Book> getBooks() {
    return books;
}
}
