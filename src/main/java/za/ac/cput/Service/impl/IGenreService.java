package za.ac.cput.Service.impl;

import za.ac.cput.entity.Genre;
import za.ac.cput.Service.IService;

import java.util.Set;

/**  IGenreService.java
    Genre Service interface
    Author: Plamedie Bitota 219260532
    Date: 1st  August 2021
 */
public interface IGenreService extends IService<Genre,String> {
    public Set<Genre> getAll();
}
