package za.ac.cput.Service.impl;

import za.ac.cput.entity.BookGenre;
import za.ac.cput.Service.IService;

import java.util.Set;

/**  IBookGenreService.java
 Book Genre Service interface
 Author: Plamedie Bitota 219260532
 Date: 1st  August 2021
 */
public interface IBookGenreService extends IService<BookGenre,String> {
    public Set<BookGenre> getAll();
}
