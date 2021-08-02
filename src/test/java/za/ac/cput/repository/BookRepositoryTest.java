package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Book;
import za.ac.cput.Factory.BookFac;
import za.ac.cput.Repository.BookRepository;


import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {
    private static BookRepository repository = BookRepository.getRepository();
    private static Book book = BookFac.createBook("4","T.Boltman","How many Stars in the sky","About Stars","Stars, sky");

    @Test
    void create(){
        Book created = repository.Create(book);
        assertEquals(created.getBookId(),book.getBookId());
        System.out.println("Created: " + created);
    }

    @Test
    void read(){
        Book read = repository.Read(book.getBookId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update(){
        Book updated = new Book.bookBuilder().copy(book).setDesc("Many many stars").build();
        assertEquals(updated,repository.Update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete(){
        boolean fail = repository.Delete(book.getBookId());
        assertFalse(fail);
        System.out.println("Deleted: " + fail);
    }

    @Test
    void getAll(){
        System.out.println("Showing all: ");
        System.out.println(repository.getAll());
    }
}
