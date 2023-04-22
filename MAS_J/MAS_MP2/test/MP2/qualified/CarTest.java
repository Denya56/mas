package MP2.qualified;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private Engine e1;
    private Engine e2;
    private Car c1;

    @Before
    public void setUp() {
        e1 = new Engine("engine1");
        e2 = new Engine("engine2");
        c1 = new Car("Car name");
    }

    @Test
    public void addEngine() {
        assertEquals(0, c1.getEngines().size());
        assertEquals(0, e1.getCars().size());
        assertEquals(0, e2.getCars().size());

        c1.addEngine(e1);
        c1.addEngine(e2);

        assertEquals(2, c1.getEngines().size());
        assertEquals(1, e1.getCars().size());
        assertEquals(1, e2.getCars().size());
    }

    @Test
    public void removeEngine() {
        assertEquals(0, c1.getEngines().size());
        assertEquals(0, e1.getCars().size());
        assertEquals(0, e2.getCars().size());

        c1.addEngine(e1);
        c1.addEngine(e2);

        assertEquals(2, c1.getEngines().size());
        assertEquals(1, e1.getCars().size());
        assertEquals(1, e2.getCars().size());

        c1.removeEngine(e1);
        assertEquals(1, c1.getEngines().size());
        assertEquals(0, e1.getCars().size());
        assertEquals(1, e2.getCars().size());
        c1.removeEngine(e2);
        assertEquals(0, c1.getEngines().size());
        assertEquals(0, e1.getCars().size());
        assertEquals(0, e2.getCars().size());
    }

    @Test
    public void engineByCode() {
        assertEquals(0, c1.getEngines().size());
        assertEquals(0, e1.getCars().size());
        assertEquals(0, e2.getCars().size());

        c1.addEngine(e1);
        c1.addEngine(e2);

        assertEquals(2, c1.getEngines().size());
        assertEquals(1, e1.getCars().size());
        assertEquals(1, e2.getCars().size());

        assertEquals("engine1", c1.engineByCode("engine1").get().getEngineCode());
        assertEquals("engine1", c1.engineByCode("engine1").get().getEngineCode());
        assertFalse(c1.engineByCode("xdd").isPresent());
    }

    @Test
    public void delete() {
        assertEquals(0, c1.getEngines().size());
        assertEquals(0, e1.getCars().size());
        assertEquals(0, e2.getCars().size());

        c1.addEngine(e1);
        c1.addEngine(e2);

        assertEquals(2, c1.getEngines().size());
        assertEquals(1, e1.getCars().size());
        assertEquals(1, e2.getCars().size());

        Car.delete(c1);
        assertEquals(0, e1.getCars().size());
        assertEquals(0, e2.getCars().size());
    }
}