package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.GenreFactory;
import za.ac.cput.entity.Genre;

import static org.junit.jupiter.api.Assertions.*;

class GenreRepositoryTest
{


    private static GenreRepository repository = GenreRepository.getRepository();
    private static Genre genre= GenreFactory.createGenre("sci fi ");

    @Test

    void o_create()
    {
        Genre created = repository.Create(genre);
        assertNotNull(created);
        System.out.println("Created: " + created);

    }

    @Test
    void p_read()
    {
        Genre read = repository.Read(genre.getGenreId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void q_update()
    {
        Genre updated = new Genre.Builder().copy(genre).setGenreId("12345").build();
        assertEquals(updated,repository.Update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void z_delete()
    {
        boolean success = repository.Delete(genre.getGenreId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}