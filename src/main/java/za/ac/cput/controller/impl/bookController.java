package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Book;
import za.ac.cput.Factory.BookFac;
import za.ac.cput.Service.impl.BookService;

import java.util.Set;

@RestController
@RequestMapping("/book")
public class bookController {

    @Autowired
    private BookService bookService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Book create(@RequestBody Book book){
        Book newBook = BookFac.createBook(book.getDesc(),"T.Boltman","Stars above","About our stars","Stars");
        return bookService.create(newBook);
    }

    @GetMapping("/read")
    public Book read(@RequestBody Book book) {
        return BookService.getService().read(book.getBookId());
    }

    @PostMapping("/update")
    public Book update(@RequestBody Book book){
        return BookService.getService().update(book);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Book book){
        if (BookService.getService().delete(book.getBookId()))
            return "Successfully Deleted";
        else
            return "Could not delete book";
    }

    @GetMapping("/getall")
    public Set<Book> getAll(){
        return BookService.getService().getAll();
    }

}
