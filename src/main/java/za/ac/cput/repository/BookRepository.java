package za.ac.cput.Repository;

import za.ac.cput.entity.Book;
import java.util.*;

public class BookRepository implements IBookRepository{
    private static BookRepository repository = null;
    private Set<Book> bookDB = null;

    private BookRepository(){
        bookDB = new HashSet<Book>();
    }

    public static BookRepository getRepository(){
        if (repository == null) {
            repository = new BookRepository();
        }
        return repository;
    }

    @Override
    public Set<Book> getAll() {
        return bookDB;
    }

    @Override
    public Book Create(Book book) {
        boolean success = bookDB.add(book);
        if(!success)
            return null;
        return book;
    }

    @Override
    public Book Read(String bookId) {
        for(Book b: bookDB)
        {
            if(b.getBookId().equals(bookId)){
                return b;
            }
        }
        return null;
    }

    @Override
    public Book Update(Book book) {
        Book oldBook = Read(book.getBookId());
        if(oldBook != null) {
            bookDB.remove(oldBook);
            bookDB.add(book);
            return book;
    }
        return book;

    }


    @Override
    public boolean Delete(String bookId) {
        Book bookToDelete = Read(bookId);
        if(bookToDelete == null)
        return false;
        bookDB.remove(bookToDelete);
        return true;
    }
}
