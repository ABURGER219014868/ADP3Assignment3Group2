/*
 *
 * @author Plamedie Bitota Bukasa (219260532)
 * Date: 10th June 2021
 */
package za.ac.cput.Factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Genre;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class GenreFactoryTest
{
    private Genre g1;
    private Genre g2;
    @Test
    public void  createGenre()
    {
        Genre genre=GenreFactory.createGenre("Romance");
        System.out.println(genre);
    }
    @Test
    void TestEquality()
    {
        assertEquals(g1,g2);
    }
    @Test
    public void testIdentity(){
        assertSame(g1, g2);
    }
    @Test
    @Timeout(value= 250, unit = TimeUnit.MILLISECONDS)
    void TestTimeout()
    {
        createGenre();
    }
    @Test
    @Disabled
    void TestDisabled(){
        createGenre();
    }
}