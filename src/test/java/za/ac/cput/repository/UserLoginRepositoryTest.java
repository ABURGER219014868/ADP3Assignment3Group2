package za.ac.cput.RepositoryTest;


import org.junit.jupiter.api.Test;
import za.ac.cput.entity.UserLogin;
import za.ac.cput.Factory.UserLoginFac;
import za.ac.cput.Repository.UserLoginRepository;

import static org.junit.jupiter.api.Assertions.*;

public class UserLoginRepositoryTest {
    private static UserLoginRepository repository = UserLoginRepository.getRepository();
    private static UserLogin uLogin = UserLoginFac.createLogin("MTB","123456");

    @Test
    void u_create(){
        UserLogin created = repository.Create(uLogin);
        assertEquals(created.getUserId(),uLogin.getUserId());
        System.out.println("Created: " + created);
    }

    @Test
    void u_read(){
        UserLogin read = repository.Read(uLogin.getUserId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void u_update(){
        UserLogin updated = new UserLogin.Builder().copy(uLogin).setUserName("ASB").build();
        assertEquals(updated,repository.Update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete(){
        boolean success = repository.Delete(uLogin.getUserId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void getAll(){
        System.out.println("Showing all: ");
        System.out.println(repository.getAll());
    }
}
