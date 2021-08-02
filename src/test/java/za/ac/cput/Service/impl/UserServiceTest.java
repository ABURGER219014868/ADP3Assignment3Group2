package za.ac.cput.Service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.User;
import za.ac.cput.Factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;
/*  UserServiceTest.java
    User Service tests
    Author: Adriaan Burger(219014868)
    Date: 27 July 2021
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
class UserServiceTest {
    private static UserService service = UserService.getService();
    private static User user = UserFactory.createUser("Carlo","Domeniconi","0124489558","koyunbaba@guitar.suite","Italy");

    @Test
    void a_create(){
        User created = service.create(user);
        assertEquals(created.getUserID(),user.getUserID());
        System.out.println("Created: " + created);
    }
    @Test
    void b_read(){
        User read = service.read(user.getUserID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        User updated = new User.Builder().copy(user).setAddress("Istanbul University State Conservatory").build();
        assertEquals(updated,service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_getAll(){
        System.out.println("Showing all: ");
        System.out.println(service.getAll());
    }

    @Test
    void e_delete(){
        boolean success = service.delete(user.getUserID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

}