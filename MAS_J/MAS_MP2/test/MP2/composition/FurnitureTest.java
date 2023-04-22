package MP2.composition;

import com.sun.source.tree.AssertTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FurnitureTest {
    private Furniture f1;

    @Before
    public void setUp() {
        f1 = new Furniture("name");
    }

    @Test
    public void addElement() {
        assertEquals(0, f1.getElements().size());
        Element e1 = new Element("name1", 1, f1);
        assertEquals(1, f1.getElements().size());
        Element e2 = new Element("name2", 5, f1);
        assertEquals(2, f1.getElements().size());
    }

    @Test
    public void removeElement() {
        assertEquals(0, f1.getElements().size());
        Element e1 = new Element("name1", 1, f1);
        assertEquals(1, f1.getElements().size());
        Element e2 = new Element("name2", 5, f1);
        assertEquals(2, f1.getElements().size());

        assertTrue(Element.getExtent().contains(e1));
        assertTrue(Element.getExtent().contains(e2));

        f1.removeElement(e1);
        assertEquals(1, f1.getElements().size());
        f1.removeElement(e2);
        assertEquals(0, f1.getElements().size());

        assertFalse(Element.getExtent().contains(e1));
        assertFalse(Element.getExtent().contains(e2));
    }

    @Test
    public void delete() {
        assertEquals(0, f1.getElements().size());
        Element e1 = new Element("name1", 1, f1);
        assertEquals(1, f1.getElements().size());
        Element e2 = new Element("name2", 5, f1);
        assertEquals(2, f1.getElements().size());

        assertTrue(Element.getExtent().contains(e1));
        assertTrue(Element.getExtent().contains(e2));
        assertTrue(Furniture.getExtent().contains(f1));


        Furniture.delete(f1);

        assertFalse(Element.getExtent().contains(e1));
        assertFalse(Element.getExtent().contains(e2));
        assertFalse(Furniture.getExtent().contains(f1));
    }
}