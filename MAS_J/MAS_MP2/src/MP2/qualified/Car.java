package MP2.qualified;

import java.util.*;

public class Car {
    private String model;

    private static final Set<Car> extent = new HashSet<>();
    private final Map<String, Engine> engines = new HashMap<>();

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model has to be specified");
        }
        this.model = model;
    }

    public static Set<Car> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

    public Map<String, Engine> getEngines() {
        return Collections.unmodifiableMap(engines);
    }

    public void addEngine(Engine engine) {
        if(engine == null) {
            throw new IllegalArgumentException("Engine cannot be null");
        }
        if(engines.containsKey(engine.getEngineCode())) return;
        engines.put(engine.getEngineCode(), engine);
        engine.addCar(this);
    }

    public void removeEngine(Engine engine) {
        if(engine == null) {
            throw new IllegalArgumentException("Engine cannot be null");
        }
        if(!engines.containsKey(engine.getEngineCode())) return;
        engines.remove(engine.getEngineCode());
        engine.removeCar(this);
    }

    public Optional<Engine> engineByCode(String code){
        if(code == null){
            throw new IllegalArgumentException("Engine code cannot be null");
        }
        return Optional.ofNullable(engines.get(code));
    }

    public static void delete(Car car) {
        if(car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        Map<String, Engine> tempEngines = Map.copyOf(car.engines);
        car.engines.clear();
        tempEngines.forEach((x, engine) -> engine.removeCar(car));
        extent.removeIf(x -> x.model.equals(car.getModel()));
    }

}
