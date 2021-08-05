package za.ac.cput.repository;
/**
 * IBookGenreRepository.java
 * @author Plamedie Bitota Bukasa (219260532)
 * Genre Repository Interface
 * Date: 28th July 2021
 */
import za.ac.cput.entity.BookGenre;

import java.util.Set;

public interface IBookGenreRepository extends IRepository<BookGenre,String>
{
    public Set<BookGenre>getAll();
}


