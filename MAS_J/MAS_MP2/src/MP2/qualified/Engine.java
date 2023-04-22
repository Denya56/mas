package MP2.qualified;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Engine {
    private static final Set<Engine> extent = new HashSet<>();

    private final Set<Car> cars = new HashSet<>();
    private String engineCode;

    public Engine(String engineCode) {
       setEngineCode(engineCode);
    }

    public static Set<Engine> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public Set<Car> getCars() {
        return Collections.unmodifiableSet(cars);
    }

    public String getEngineCode() {
        return engineCode;
    }

    public void setEngineCode(String engineCode) {
        if(engineCode == null || engineCode.isBlank()) {
            throw new IllegalArgumentException("Engine code has to be specified");
        }
        this.engineCode = engineCode;
    }

    public void addCar(Car car) {
        if(car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        if(cars.contains(car)) return;
        cars.add(car);
        car.addEngine(this);
    }

    public void removeCar(Car car) {
        if(car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        if(!cars.contains(car)) return;
        cars.remove(car);
        car.removeEngine(this);
    }

    public static void delete(Engine engine) {
        if(engine == null) {
            throw new IllegalArgumentException("Engine cannot be null");
        }
        Set<Car> tempCars = Set.copyOf(engine.cars);
        engine.cars.clear();
        tempCars.forEach(x -> x.removeEngine(engine));
        extent.removeIf(x -> x.engineCode.equals(engine.engineCode));
    }
}
