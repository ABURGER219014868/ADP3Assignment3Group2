package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.BookAlert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/*
    Author: Ruphin Bolonda
    Student Number: 218321392
    Description: BookAlertFactoryTest class
 */

class BookAlertFactoryTest {
    @Test
    public void testObjectEquality(){
        BookAlert bookAlert1 = BookAlertFactory.createBookAlert("Vortex","Book not returned",
                true);
        BookAlert bookAlert2 = bookAlert1;
        assertEquals(bookAlert1,bookAlert2);
    }

    @Test
    public void testIfObjectsIdentity() {

        BookAlert bookAlert1 = BookAlertFactory.createBookAlert("Vortex","Book not returned",
                true);
        BookAlert bookAlert2 = bookAlert1;
        assertSame(bookAlert1, bookAlert2);
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testDataAccessTimeout(){
        BookAlert bookAlert1 = BookAlertFactory.createBookAlert("Vortex","Book not returned",true);
    }

    @Disabled
    @Test
    public void testCreateBookAlertBis(){

        BookAlert bookAlert = BookAlertFactory.createBookAlert("Vortex","Book not returned",
                true);

        System.out.println(bookAlert);
        assertNotNull(bookAlert);

    }
}