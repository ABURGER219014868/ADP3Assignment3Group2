package za.ac.cput.repository;
/**
 * IGenreRepository.java
 * @author Plamedie Bitota Bukasa (219260532)
 * Genre Repository Interface
 * Date: 28th July 2021
 */
import za.ac.cput.entity.Genre;

import java.util.Set;

   public interface IGenreRepository extends IRepository<Genre,String>
{
    public Set<Genre>getAll();
}


