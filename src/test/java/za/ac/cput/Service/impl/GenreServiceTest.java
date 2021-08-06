package za.ac.cput.Service.impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.GenreFactory;
import za.ac.cput.entity.Genre;

import static org.junit.jupiter.api.Assertions.*;

class GenreServiceTest {

    private static GenreService service = GenreService.getService();
    private static Genre Genre = GenreFactory.createGenre("Action");

    @Test
    void a_create(){
        Genre created = service.create(Genre);
        assertEquals(created.getGenreId(),Genre.getGenreId());
        System.out.println("Created: " + created);
    }
    @Test
    void b_read(){
        Genre read = service.read(Genre.getGenreId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        Genre updated = new Genre.Builder().copy(Genre).setGenreId("123456").build();
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
        boolean success = service.delete(Genre.getGenreId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

}