package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Role;
import za.ac.cput.Factory.RoleFactory;

import static org.junit.jupiter.api.Assertions.*;
/*  RoleRepositoryTest.java
    Role Repository tests
    Author: Adriaan Burger(219014868)
    Date: 25 July 2021
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class RoleRepositoryTest {
    private static RoleRepository repository = RoleRepository.getRepository();
    private static Role role = RoleFactory.createRole("librarian","Works in library");

    @Test
    void a_create(){
        Role created = repository.create(role);
        assertEquals(created.getRoleID(),role.getRoleID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read(){
        Role read = repository.read(role.getRoleID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        Role updated = new Role.Builder().copy(role).setDescription("Works in school library").build();
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
        boolean success = repository.delete(role.getRoleID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}