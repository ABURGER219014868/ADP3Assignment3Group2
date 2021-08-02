package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.BookLoanLog;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/*
    Author: Ruphin Bolonda
    Student Number: 218321392
    Description: BookLoanLogFactoryTest class
 */

class BookLoanLogFactoryTest {
    @Test
    public void createBookLoanLog(){
        BookLoanLog bookLoanLog1 = BookLoanLogFactory.createBookLoanLog("11/06/2021",
                                                            "13/06/2021",false);
        BookLoanLog bookLoanLog2 = bookLoanLog1;
        assertEquals(bookLoanLog1,bookLoanLog2);
    }
    @Test
    public void testIfObjectsIdentity() {

        BookLoanLog bookLoanLog1 = BookLoanLogFactory.createBookLoanLog("11/06/2021",
                "13/06/2021",false);
        BookLoanLog bookLoanLog2 = bookLoanLog1;
        assertSame(bookLoanLog1, bookLoanLog2);
    }
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testDataAccessTimeout(){
        BookLoanLog bookLoanLog1 = BookLoanLogFactory.createBookLoanLog("11/06/2021",
                "13/06/2021",false);
    }

    @Disabled
    @Test
    public void testCreateBookAlertBis(){

        BookLoanLog bookLoanLog1 = BookLoanLogFactory.createBookLoanLog("11/06/2021",
                "13/06/2021",false);
        assertNotNull(bookLoanLog1);

    }
}