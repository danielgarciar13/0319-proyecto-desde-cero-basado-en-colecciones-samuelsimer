import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class tiendaGuitarrasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class tiendaGuitarrasTest
{
    /**
     * Default constructor for test class tiendaGuitarrasTest
     */
    public tiendaGuitarrasTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testCommit07()
    {
        tiendaGuitarras tiendaGu1 = new tiendaGuitarras();
        tiendaGu1.agregarGuitarra("Guitarra normal", 5, 1000, false);
        tiendaGu1.agregarGuitarra("Guitarra barata", 4, 120, true);
        tiendaGu1.agregarGuitarra("Guitarra cara", 6, 2500, false);
        assertEquals("Guitarra barata 120.0\nGuitarra normal 1000.0\nGuitarra cara 2500.0\n", tiendaGu1.getGuitarrasPorPrecio());
        tiendaGu1.agregarGuitarra("Guitarra de Elvis Presley", 25, 8000000, true);
        assertEquals("Guitarra barata 120.0\nGuitarra normal 1000.0\nGuitarra cara 2500.0\nGuitarra de Elvis Presley 8000000.0\n", tiendaGu1.getGuitarrasPorPrecio());
        tiendaGu1.agregarGuitarra("Guitarra reciclada", 4, 20, true);
        assertEquals("Guitarra reciclada 20.0\nGuitarra barata 120.0\nGuitarra normal 1000.0\nGuitarra cara 2500.0\nGuitarra de Elvis Presley 8000000.0\n", tiendaGu1.getGuitarrasPorPrecio());
        tiendaGu1.agregarGuitarra("Guitarra verde", 4, 60, true);
        tiendaGu1.agregarGuitarra("Guitarra roja", 4, 1750, true);
        tiendaGu1.agregarGuitarra("Guitarra azul", 4, 1, true);
        assertEquals("Guitarra azul 1.0\nGuitarra reciclada 20.0\nGuitarra verde 60.0\nGuitarra barata 120.0\nGuitarra normal 1000.0\nGuitarra roja 1750.0\nGuitarra cara 2500.0\nGuitarra de Elvis Presley 8000000.0\n", tiendaGu1.getGuitarrasPorPrecio());
    }
}

