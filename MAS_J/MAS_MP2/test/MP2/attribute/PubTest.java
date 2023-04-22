package MP2.attribute;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PubTest {
    private Beer b1;
    private Beer b2;
    private Pub p1;
    private Pub p2;
    private BeerDelivery bd1;
    private BeerDelivery bd2;

    @Before
    public void setUp() {
        b1 = new Beer("name");
        b2 = new Beer("name2");
        p1 = new Pub("name");
        p2 = new Pub("name2");
        bd1 = new BeerDelivery("02-10-2023", b1, p1);
        bd2 = new BeerDelivery("15-10-2023", b2, p2);
    }

    @Test
    public void BeerTest() {
        assertEquals(1, p1.getBeerDelivery().size());
        assertEquals(1, p2.getBeerDelivery().size());

        p1.removeBeerDeliveryRecord(bd1);
        assertEquals(0, p1.getBeerDelivery().size());
        p2.removeBeerDeliveryRecord(bd2);
        assertEquals(0, p2.getBeerDelivery().size());

        Pub.delete(p1);
        assertEquals(1, Pub.getExtent().size());
        Pub.delete(p2);
        assertEquals(0, Pub.getExtent().size());
    }
}