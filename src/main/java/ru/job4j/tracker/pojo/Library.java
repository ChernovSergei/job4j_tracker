package ru.job4j.tracker.pojo;

public class Library {
    public static void changeBooks(Book[] books, int first, int second) {
        Book onHand = books[first];
        books[first] = books[second];
        books[second] = onHand;
    }

    public static void print(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println("Book name: " + books[i].getName() + "\t, number of pages: " + books[i].getSheets());
            }
        }
        System.out.println();
    }

    public static void print(Book[] books, String bookName) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getName().equals(bookName)) {
                System.out.println("Book name: " + books[i].getName() + "\t, number of pages: " + books[i].getSheets());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Book warAndPeace = new Book("War And Peace", 1000000);
        Book littlePrince = new Book("Little Prince", 200);
        Book cleanCode = new Book("Clean Code", 534);
        Book rambo = new Book("Rambo", 732);
        Book[] books = new Book[10];
        books[0] = warAndPeace;
        books[1] = littlePrince;
        books[2] = cleanCode;
        books[3] = rambo;
        print(books);
        changeBooks(books, 0, 3);
        print(books);
        print(books, "Clean Code");
    }
}
