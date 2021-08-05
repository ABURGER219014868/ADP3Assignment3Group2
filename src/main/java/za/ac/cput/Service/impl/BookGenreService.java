package za.ac.cput.Service.impl;

import za.ac.cput.Service.impl.IBookGenreService;
import za.ac.cput.entity.BookGenre;
import za.ac.cput.repository.BookGenreRepository;

import java.util.Set;

/**  GenreService.java
 Book Genre Service implementation
 Author: Plamedie Bitota 219260532
 Date: 1st August 2021
 */
public class BookGenreService implements IBookGenreService {
    private static za.ac.cput.Service.impl.BookGenreService service = null;
    private BookGenreRepository repository = null;

    private BookGenreService(){ this.repository = BookGenreRepository.getRepository();}

    public static za.ac.cput.Service.impl.BookGenreService getService(){
        if(service == null){
            service = new za.ac.cput.Service.impl.BookGenreService();
        }
        return service;
    }

    @Override
    public BookGenre create(BookGenre bookGenre) { return this.repository.Create(bookGenre);  }

    @Override
    public BookGenre read(String BookGenreId) { return this.repository.Read(BookGenreId); }

    @Override
    public BookGenre update(BookGenre bookGenre ) {  return this.repository.Update(bookGenre);  }

    @Override
    public boolean delete(String bookGenreId) {  return this.repository.Delete(bookGenreId); }

    @Override
    public Set<BookGenre> getAll() {   return this.repository.getAll();  }
}
