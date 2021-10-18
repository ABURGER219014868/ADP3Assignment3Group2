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
import za.ac.cput.Entity.UserLogin;
import za.ac.cput.Factory.UserLoginFac;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class userloginControllerTest {
    private static UserLogin userLogin = UserLoginFac.createLogin("Boltman", "123456");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/userlogin";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<UserLogin> postResponse = restTemplate.postForEntity(url, userLogin, UserLogin.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), httpStatus.OK);
        userLogin = postResponse.getBody();
        System.out.println("Saved data: " + userLogin);
        assertEquals(userLogin.getUserId(), postResponse.getBody().getUserId());
    }

    @Test
    void read() {
        String url = baseURL + "/read" + userLogin.getUserId();
        System.out.println("URL: " + url);
        ResponseEntity<UserLogin> response = restTemplate.getForEntity(url, UserLogin.class);
        assertEquals(userLogin.getUserId(), response.getBody().getUserId());
    }

    @Test
    void update() {
        UserLogin updated = new UserLogin.Builder().copy(userLogin).setUserId("Taahir").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<UserLogin> response = restTemplate.postForEntity(url, updated, UserLogin.class);
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {
        String url = baseURL + "/delete" + userLogin.getUserId();
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