package history;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Beer {
    private String name;

    private static final Set<Beer> extent = new HashSet<>();

    private final Set<BeerDelivery> beerDeliveries = new HashSet<>();

    public Beer(String name) {
        setName(name);
        extent.add(this);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name has to be specified");
        }
        this.name = name;
    }

    public static Set<Beer> getExtent() {
        return Collections.unmodifiableSet(extent);
    }
    public Set<BeerDelivery> getBeerDelivery() {
        return Collections.unmodifiableSet(beerDeliveries);
    }

    public void addBeerDeliveryRecord(BeerDelivery beerDelivery) {
        if(beerDelivery == null){
            throw new IllegalArgumentException("Beer delivery record cannot be null");
        }
        if(beerDeliveries.contains(beerDelivery)) return;
        beerDeliveries.add(beerDelivery);
    }

    public void removeBeerDeliveryRecord(BeerDelivery beerDelivery) {
        if(beerDelivery == null){
            throw new IllegalArgumentException("Beer delivery record cannot be null");
        }
        if(!beerDeliveries.contains(beerDelivery)) return;
        beerDeliveries.remove(beerDelivery);
        BeerDelivery.delete(beerDelivery);
    }

    public static void delete(Beer beer) {
        if(beer == null) {
            throw new IllegalArgumentException("Beer cannot be null");
        }
        Set<BeerDelivery> tempDeliveries = Set.copyOf(beer.beerDeliveries);
        beer.beerDeliveries.clear();
        tempDeliveries.forEach(BeerDelivery::delete);
        extent.remove(beer);
    }
}

