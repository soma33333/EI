package Behavioural.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class BookCollection implements Iterable<Book> {
    private List<Book> books;

    public BookCollection() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
}


public class BookCollectionsystem {
    public static void main(String[] args) {

        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(new Book("The Catcher in the Rye"));
        bookCollection.addBook(new Book("To Kill a Mockingbird"));
        bookCollection.addBook(new Book("1984"));

        Iterator<Book> iterator = bookCollection.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("Book: " + book.getTitle());
        }
    }
}
