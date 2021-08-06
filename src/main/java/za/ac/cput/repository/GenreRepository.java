package za.ac.cput.repository;
/**
 * GenreRepository.java
 * @author Plamedie Bitota Bukasa (219260532)
 * Genre Repository Implementation
 * Date: 28th July 2021
 */
import za.ac.cput.Factory.GenreFactory;
import za.ac.cput.entity.Genre;


import java.util.HashSet;
import java.util.Set;

public class GenreRepository implements IGenreRepository
{
    private static GenreRepository repository = null;
    private Set<Genre> genreDB = null;

    private GenreRepository(){
        genreDB = new HashSet<Genre>();
    }

    public static GenreRepository getRepository(){
        if (repository == null) {
            repository = new GenreRepository();
        }
        return repository;
    }

    public Genre Create(Genre genre)
    {
        Genre g= GenreFactory.createGenre("SCIFI");
        this.genreDB.add(g);
        return g;
    }
   @Override
    public Genre Read (String genreId)
    {
        Genre genre=null;
        for (Genre g: genreDB)
        {
            if (g.getGenreId().equalsIgnoreCase((genreId)))
            {
                genre = g;
                break;
            }

        }
        return genre;
    }
    @Override
    public Genre Update  (Genre genre)
    {
        Genre oldGenre=Read(genre.getGenreId());
        if(oldGenre!=null)
        {
           genreDB.remove(oldGenre);
           genreDB.add(genre);
           return genre;
        }
        return genre;
    }

  @Override
    public boolean Delete (String genreId)
    {
        Genre genreToDelete = Read(genreId);
        if(genreToDelete!= null)
            return false;
        genreDB.remove(genreToDelete);
            return true;
    }

    @Override
    public Set<Genre> getAll() {
        return null;
    }


}
