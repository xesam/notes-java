package io.github.xesam.lang.collection;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by x on 2015/7/24.
 */
public class SortTest {


    static Collator cmp = Collator.getInstance(java.util.Locale.CHINA);

    public static void main(String[] args) {

        List<Book> books = Book.getBooks();

        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book left, Book right) {
                int ret = 0;

                if (left.inFav == right.inFav) {
                    if (left.priority > right.priority) {
                        ret = 1;
                    } else if (left.priority < right.priority) {
                        ret = -1;
                    } else {
                        if (cmp.compare(left.name, right.name) > 0) {
                            ret = 1;
                        } else if (cmp.compare(left.name, right.name) < 0) {
                            ret = -1;
                        } else {
                            ret = 0;
                        }
                    }
                } else if (left.inFav) {
                    ret = -1;
                } else {
                    ret = 1;
                }
                return ret;
            }
        });
        books.stream().forEach(book -> {
            System.out.println(book);
        });

    }
}
