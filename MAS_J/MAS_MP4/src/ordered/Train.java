package ordered;

import subset.BasketballPlayer;
import subset.BasketballTeam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Train {
    private String routeName;
    private Set<Car> cars = new HashSet<>();

    public Train(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteName() {
        return routeName;
    }

    private void setName(String routeName) {
        if(routeName == null || routeName.isBlank()) {
            throw new IllegalArgumentException("Route name has to be specified");
        }
        this.routeName = routeName;
    }

    public List<Car> getCars() {
        return cars.stream().sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getColor(), o2.getColor())).toList();
    }

    public void addCar(Car car) {
        if(car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        if(cars.contains(car)) return;
        cars.add(car);
        car.addTrain(this);
    }

    public void removeCar(Car car) {
        if(car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        if(cars.contains(car)) return;
        cars.remove(car);
        car.removeTrain(this);
    }

    public static void delete(Train train) {
        if(train == null) {
            throw new IllegalArgumentException("Train cannot be null");
        }
        Set<Car> tempCars = Set.copyOf(train.cars);
        train.cars.clear();

        tempCars.forEach(x -> x.removeTrain(train));
        //extent.remove(player);
    }
}
