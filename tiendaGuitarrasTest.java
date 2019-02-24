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
    private TiendaGuitarras tiendaGu1;

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
        tiendaGu1 = new TiendaGuitarras();
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
        TiendaGuitarras tiendaGu1 = new TiendaGuitarras();
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

    @Test
    public void testGetGuitarrasPorAgrupacionesDePrecio()
    {
        assertEquals("Caras:\n\nMuy caras:\n\nMuy baratas:\n\nBaratas:\n\n", tiendaGu1.getGuitarrasPorAgrupacionesDePrecio());
        tiendaGu1.agregarGuitarra("Guitarra 1", 4, 200, true);
        assertEquals("Caras:\n\nMuy caras:\n\nMuy baratas:\nGuitarra 1, 200.0, 4, electrica\n\nBaratas:\n\n", tiendaGu1.getGuitarrasPorAgrupacionesDePrecio());
        tiendaGu1.agregarGuitarra("Guitarra 2", 6, 300, true);
        tiendaGu1.agregarGuitarra("Guitarra 3", 8, 1200, true);
        tiendaGu1.agregarGuitarra("Guitarra 4", 4, 1600, true);
        tiendaGu1.agregarGuitarra("Guitarra 5", 4, 150, true);
        tiendaGu1.agregarGuitarra("Guitarra 6", 4, 450, true);
        tiendaGu1.agregarGuitarra("Guitarra 7", 6, 1400, true);
        tiendaGu1.agregarGuitarra("Guitarra 8", 6, 1201, true);
        tiendaGu1.agregarGuitarra("Guitarra 9", 6, 301, true);
        tiendaGu1.agregarGuitarra("Guitarra 10", 4, 700, true);
        tiendaGu1.agregarGuitarra("Guitarra 11", 4, 850, true);
        tiendaGu1.agregarGuitarra("Guitarra 12", 8, 500, true);
        tiendaGu1.agregarGuitarra("Guitarra 13", 6, 1000, true);
        tiendaGu1.agregarGuitarra("Guitarra 14", 4, 2000, true);
        assertEquals("Caras:\nGuitarra 3, 1200.0, 8, electrica\nGuitarra 10, 700.0, 4, electrica\nGuitarra 11, 850.0, 4, electrica\nGuitarra 13, 1000.0, 6, electrica\n\nMuy caras:\nGuitarra 4, 1600.0, 4, electrica\nGuitarra 7, 1400.0, 6, electrica\nGuitarra 14, 2000.0, 4, electrica\n\nMuy baratas:\nGuitarra 1, 200.0, 4, electrica\nGuitarra 2, 300.0, 6, electrica\nGuitarra 5, 150.0, 4, electrica\n\nBaratas:\nGuitarra 6, 450.0, 4, electrica\nGuitarra 9, 301.0, 6, electrica\nGuitarra 12, 500.0, 8, electrica\n\n", tiendaGu1.getGuitarrasPorAgrupacionesDePrecio());
    }
}



