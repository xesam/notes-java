package dev.xesam.javalang.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x on 2015/7/24.
 */
public class Book {
    boolean inFav;
    int priority;
    String name;

    public Book(boolean inFav, int priority, String name) {
        this.inFav = inFav;
        this.priority = priority;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "inFav=" + inFav +
                ", priority=" + priority +
                ", name='" + name + '\'' +
                '}';
    }

    static List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(false, 1, "ABC"));
        books.add(new Book(false, 2, "ABC"));
        books.add(new Book(false, 2, "ABC"));
        books.add(new Book(true, 5, "ABC"));
        books.add(new Book(false, 4, "ABC"));
        books.add(new Book(false, 6, "ABC"));
        books.add(new Book(true, 1, "BCA"));
        books.add(new Book(true, 1, "ABC"));
        books.add(new Book(true, 1, "CBA"));
        books.add(new Book(true, 3, "ABC"));
        books.add(new Book(false, 4, "ABC"));
        books.add(new Book(true, 4, "ABC"));
        books.add(new Book(true, 6, "ABC"));
        return books;
    }
}
