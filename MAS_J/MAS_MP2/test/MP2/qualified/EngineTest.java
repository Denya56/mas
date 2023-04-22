package MP2.qualified;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EngineTest {
    private Engine e1;
    private Car c1;
    private Car c2;

    @Before
    public void setUp() {
        e1 = new Engine("name1");
        c1 = new Car("Car name");
        c2 = new Car("Car name2");
    }

    @Test
    public void addCar() {
        assertEquals(0, c1.getEngines().size());
        assertEquals(0, c2.getEngines().size());
        assertEquals(0, e1.getCars().size());

        e1.addCar(c1);
        e1.addCar(c2);

        assertEquals(1, c1.getEngines().size());
        assertEquals(1, c2.getEngines().size());
        assertEquals(2, e1.getCars().size());
    }

    @Test
    public void removeCar() {
        assertEquals(0, c1.getEngines().size());
        assertEquals(0, c2.getEngines().size());
        assertEquals(0, e1.getCars().size());

        e1.addCar(c1);
        e1.addCar(c2);

        assertEquals(1, c1.getEngines().size());
        assertEquals(1, c2.getEngines().size());
        assertEquals(2, e1.getCars().size());

        e1.removeCar(c1);
        assertEquals(0, c1.getEngines().size());
        assertEquals(1, c2.getEngines().size());
        assertEquals(1, e1.getCars().size());

        e1.removeCar(c2);
        assertEquals(0, c1.getEngines().size());
        assertEquals(0, c2.getEngines().size());
        assertEquals(0, e1.getCars().size());
    }

    @Test
    public void delete() {
        assertEquals(0, c1.getEngines().size());
        assertEquals(0, c2.getEngines().size());
        assertEquals(0, e1.getCars().size());

        e1.addCar(c1);
        e1.addCar(c2);

        assertEquals(1, c1.getEngines().size());
        assertEquals(1, c2.getEngines().size());
        assertEquals(2, e1.getCars().size());

        Engine.delete(e1);
        assertEquals(0, c1.getEngines().size());
        assertEquals(0, c2.getEngines().size());

    }
}