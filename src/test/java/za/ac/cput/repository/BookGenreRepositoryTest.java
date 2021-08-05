package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.BookGenreFactory;
import za.ac.cput.entity.BookGenre;

import static org.junit.jupiter.api.Assertions.*;

class BookGenreRepositoryTest
{
    private static BookGenreRepository repository = BookGenreRepository.getRepository();
    private static BookGenre bookGenre;
    private Object BookGenre;

    @Test

    void create()
    {
    BookGenre created = repository.Create(bookGenre);
    assertEquals(created.getbookGenreId(),bookGenre.getbookGenreId());
        System.out.println("Created: " + created);

    }

    @Test
    void read()
    {
        BookGenre read = repository.Read(bookGenre.getbookGenreId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update()
    {
        BookGenre updated = new BookGenre().Builder().copy(BookGenre).setName().build();
        assertEquals(updated,repository.Update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete()
    {
        boolean success = repository.Delete(bookGenre.getbookGenreId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}