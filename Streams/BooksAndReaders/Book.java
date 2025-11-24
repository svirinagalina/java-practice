package Streams.BooksAndReaders;

 class Book {
    private int number;
    private String author;
    private String title;

     public Book(int number, String author, String title) {
         this.number = number;
         this.author = author;
         this.title = title;
     }

     public int getNumber() {
         return number;
     }

     public String getAuthor() {
         return author;
     }

     public String getTitle() {
         return title;
     }

     public void setNumber(int number) {
         this.number = number;
     }

     public void setAuthor(String author) {
         this.author = author;
     }

     public void setTitle(String title) {
         this.title = title;
     }

     @Override
     public String toString() {
         return number + "#" + author + "#" + title;
     }
 }
