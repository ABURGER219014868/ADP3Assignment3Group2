package za.ac.cput.repository;

import za.ac.cput.entity.Book;

import java.util.*;

public interface IBookRepository extends IRepository<Book, String>{
    public Set<Book> getAll();
}
