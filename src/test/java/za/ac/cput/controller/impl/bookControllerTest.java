//Taahir Boltman - 218022972
package za.ac.cput.ControllerTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Book;
import za.ac.cput.Factory.BookFac;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class bookControllerTest {
private static Book book = BookFac.createBook("4","T.Boltman","Sun Baby","ABOUT SUN","Sun");
@Autowired
private TestRestTemplate restTemplate;
private final String baseURL = "http://localhost:8080/book";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Book> postResponse = restTemplate.postForEntity(url, book, Book.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), httpStatus.OK);
        book = postResponse.getBody();
        System.out.println("Saved data: " + book);
        assertEquals(book.getBookId(), postResponse.getBody().getBookId());
    }

    @Test
    void read() {
        String url = baseURL + "/read" + book.getBookId();
        System.out.println("URL: " + url);
        ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);
        assertEquals(book.getBookId(), response.getBody().getBookId());
    }

    @Test
    void update() {
        Book updated = new Book.bookBuilder().copy(book).setDesc("Chicken").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Book> response = restTemplate.postForEntity(url, updated, Book.class);
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {
        String url = baseURL + "/delete" + book.getBookId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}