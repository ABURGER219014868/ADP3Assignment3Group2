package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.User;
import za.ac.cput.Factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
/*  UserRepositoryTest.java
    User Repository tests
    Author: Adriaan Burger(219014868)
    Date: 25 July 2021
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class UserRepositoryTest {
    private static UserRepository repository = UserRepository.getRepository();
    private static User user = UserFactory.createUser("R2D2","Droid","001110010","thedroids@youarelook.ing.for","Not That Planet");

    @Test
    void a_create(){
        User created = repository.create(user);
        assertEquals(created.getUserID(),user.getUserID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read(){
        User read = repository.read(user.getUserID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        User updated = new User.Builder().copy(user).setAddress("That Other Planet").build();
        assertEquals(updated,repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_getAll(){
        System.out.println("Showing all: ");
        System.out.println(repository.getAll());
    }

    @Test
    void e_delete(){
        boolean success = repository.delete(user.getUserID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}