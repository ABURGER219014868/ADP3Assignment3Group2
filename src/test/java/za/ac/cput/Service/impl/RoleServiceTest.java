package za.ac.cput.Service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Role;
import za.ac.cput.Factory.RoleFactory;

import static org.junit.jupiter.api.Assertions.*;
/*  RoleServiceTest.java
    Role Service tests
    Author: Adriaan Burger(219014868)
    Date: 27 July 2021
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
class RoleServiceTest {
    private static RoleService service = RoleService.getService();
    private static Role role = RoleFactory.createRole("Student","Reads book");

    @Test
    void a_create(){
        Role created = service.create(role);
        assertEquals(created.getRoleID(),role.getRoleID());
        System.out.println("Created: " + created);
    }
    @Test
    void b_read(){
        Role read = service.read(role.getRoleID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        Role updated = new Role.Builder().copy(role).setDescription("Reads library book").build();
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
        boolean success = service.delete(role.getRoleID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

}