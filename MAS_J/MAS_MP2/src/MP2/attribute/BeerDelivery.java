package MP2.attribute;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BeerDelivery {
    private String deliveryDate;
    private Beer beer;
    private Pub pub;

    private static final Set<BeerDelivery> extent = new HashSet<>();

    public BeerDelivery(String deliveryDate, Beer beer, Pub pub) {
        setDeliveryDate(deliveryDate);
        setBeer(beer);
        setPub(pub);
        beer.addBeerDeliveryRecord(this);
        pub.addBeerDeliveryRecord(this);
        extent.add(this);
    }

    public static Set<BeerDelivery> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        if(deliveryDate == null || deliveryDate.isBlank()) {
            throw new IllegalArgumentException("Date has to be specified");
        }
        this.deliveryDate = deliveryDate;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        if(beer == null) {
            throw new IllegalArgumentException("Beer cannot be null");
        }
        this.beer = beer;
    }

    public Pub getPub() {
        return pub;
    }

    public void setPub(Pub pub) {
        if(pub == null) {
            throw new IllegalArgumentException("Pub cannot be null");
        }
        this.pub = pub;
    }

    public static void delete(BeerDelivery beerDelivery) {
        if(beerDelivery == null) {
            throw new IllegalArgumentException("Beer delivery cannot be null");
        }
        beerDelivery.beer.removeBeerDeliveryRecord(beerDelivery);
        beerDelivery.pub.removeBeerDeliveryRecord(beerDelivery);
        extent.remove(beerDelivery);
    }
}
