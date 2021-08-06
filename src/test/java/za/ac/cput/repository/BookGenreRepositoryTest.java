package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Factory.BookGenreFactory;
import za.ac.cput.entity.BookGenre;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class BookGenreRepositoryTest
{
    private static BookGenreRepository repository = BookGenreRepository.getRepository();
    private static BookGenre bookGenre=BookGenreFactory.createBookGenre("sci fi ");

    @Test

    void o_create()
    {
    BookGenre created = repository.Create(bookGenre);
    assertNotNull(created);
        System.out.println("Created: " + created);

    }

    @Test
    void p_read()
    {
        BookGenre read = repository.Read(bookGenre.getbookGenreId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void q_update()
    {
        BookGenre updated = new BookGenre.Builder().copy(bookGenre).setBookGenreId("Romance").build();
        assertEquals(updated,repository.Update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void z_delete()
    {
        boolean success = repository.Delete(bookGenre.getbookGenreId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}