package za.ac.cput.repository;
/**
 * GenreRepository.java
 * @author Plamedie Bitota Bukasa (219260532)
 * Genre Repository Implementation
 * Date: 28th July 2021
 */
import za.ac.cput.Factory.BookGenreFactory;
import za.ac.cput.entity.BookGenre;


import java.util.HashSet;
import java.util.Set;

public class BookGenreRepository implements IBookGenreRepository
{
    private static BookGenreRepository repository = null;
    private Set<BookGenre> bookGenreDB = null;

    private BookGenreRepository(){
        bookGenreDB = new HashSet<BookGenre>();
    }

    public static BookGenreRepository getRepository(){
        if (repository == null) {
            repository = new BookGenreRepository();
        }
        return repository;
    }

    @Override

    public BookGenre Create(BookGenre bookgenre)
    {
        BookGenre g= BookGenreFactory.createBookGenre(bookgenre);
        this.bookGenreDB.add(bookgenre);
        return bookgenre;
    }
    @Override
    public BookGenre Read (String bookGenreID)
    {
        BookGenre bookGenre=null;
        for (BookGenre g: bookGenreDB)
        {
            if (g.getbookGenreId().equalsIgnoreCase((bookGenreID)))
            {
                bookGenre = g;
                break;
            }

        }
        return bookGenre;
    }
    @Override
    public BookGenre Update  (BookGenre bookGenre)
    {
        BookGenre oldBookGenre=Read(bookGenre.getbookGenreId());
        if(oldBookGenre!=null)
        {
            bookGenreDB.remove(oldBookGenre);
            bookGenreDB.add(bookGenre);
            return bookGenre;
        }
        return bookGenre;
    }

    @Override
    public boolean Delete (String bookGenreId)
    {
        BookGenre bookGenreToDelete = Read(bookGenreId);
        if(bookGenreToDelete!= null)
            return false;
        bookGenreDB.remove(bookGenreToDelete);
        return true;
    }

    @Override
    public Set<BookGenre> getAll() {
        return null;
    }


}

