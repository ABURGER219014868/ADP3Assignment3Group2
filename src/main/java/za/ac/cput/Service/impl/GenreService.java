package za.ac.cput.Service.impl;

import za.ac.cput.Service.impl.IGenreService;
import za.ac.cput.entity.Genre;
import za.ac.cput.repository.GenreRepository;

import java.util.Set;

/**  GenreService.java
    Genre Service implementation
    Author: Plamedie Bitota 219260532
    Date: 1st August 2021
 */
public class GenreService implements IGenreService {
    private static za.ac.cput.Service.impl.GenreService service = null;
    private GenreRepository repository = null;

    private GenreService(){ this.repository = GenreRepository.getRepository();}

    public static za.ac.cput.Service.impl.GenreService getService(){
        if(service == null){
            service = new za.ac.cput.Service.impl.GenreService();
        }
        return service;
    }

    @Override
    public Genre create(Genre genre) { return this.repository.Create(genre);  }

    @Override
    public Genre read(String genreId) { return this.repository.Read(genreId); }

    @Override
    public Genre update(Genre genre ) {  return this.repository.Update(genre);  }

    @Override
    public boolean delete(String genreId) {  return this.repository.Delete(genreId); }

    @Override
    public Set<Genre> getAll() {   return this.repository.getAll();  }
}
