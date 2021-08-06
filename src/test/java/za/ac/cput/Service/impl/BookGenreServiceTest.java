package za.ac.cput.Service.impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.BookGenreFactory;
import za.ac.cput.entity.BookGenre;

import static org.junit.jupiter.api.Assertions.*;

class BookGenreServiceTest {

    private static BookGenreService service = BookGenreService.getService();
    private static BookGenre bookGenre = BookGenreFactory.createBookGenre("Action");

    @Test
    void a_create(){
        BookGenre created = service.create(bookGenre);
        assertEquals(created.getbookGenreId(),bookGenre.getbookGenreId());
        System.out.println("Created: " + created);
    }
    @Test
    void b_read(){
        BookGenre read = service.read(bookGenre.getbookGenreId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        BookGenre updated = new BookGenre.Builder().copy(bookGenre).setBookGenreId("123456").build();
        assertEquals(updated,service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_getAll(){
        System.out.println("Showing all: ");
        System.out.println(service.getAll());
    }

    @Test
    void e_delete(){
        boolean success = service.delete(bookGenre.getbookGenreId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

}