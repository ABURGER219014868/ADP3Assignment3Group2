/*
 * @author Plamedie Bitota Bukasa (219260532)
 * Date: 10th June 2021
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.BookGenre;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BookGenreFactoryTest
{
    private BookGenre b1;
    private BookGenre b2;
    @Test
public void  createBookGenre()
{
    b1=BookGenreFactory.createBookGenre();
    b2=BookGenreFactory.createBookGenre();


}
@Test
void TestEquality()
{
   assertEquals(b1,b2);
}
@Test
public void testIdent(){
    assertSame(b1, b1);
}
    @Test
    @Timeout(value= 250, unit = TimeUnit.MILLISECONDS)
    void TestTimeout()
    {
        createBookGenre();
    }
    @Test
    @Disabled
    void TestDisabled(){
        createBookGenre();
    }
}