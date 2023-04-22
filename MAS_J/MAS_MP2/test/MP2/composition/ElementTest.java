package MP2.composition;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementTest {
    private Furniture f1;

    @Before
    public void setUp() {
        f1 = new Furniture("name");
    }


    @Test
    public void createElementFurniture() {
        assertEquals(0, f1.getElements().size());
        Element e1 = new Element("name1", 1, f1);
        Element e2 = new Element("name2", 5, f1);
        assertEquals(2, f1.getElements().size());
    }

    @Test
    public void delete() {
        assertEquals(0, f1.getElements().size());
        Element e1 = new Element("name1", 1, f1);
        Element e2 = new Element("name2", 5, f1);
        assertEquals(2, f1.getElements().size());
        Element.delete(e1);
        assertEquals(1, f1.getElements().size());
    }
}