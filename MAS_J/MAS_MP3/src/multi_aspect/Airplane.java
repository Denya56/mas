package multi_aspect;

public class Airplane extends Vehicle {
    private int numberOfEngines;

    public Airplane(String name, double horsepower, EngineType engineType, int numberOfPistons, String jetFuelType, int numberOfEngines) {
        super(name, horsepower, engineType, numberOfPistons, jetFuelType);
        setNumberOfEngines(numberOfEngines);
    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    private void setNumberOfEngines(int numberOfEngines) {
        if(numberOfEngines <= 0)
        {
            throw new IllegalArgumentException("Number of engines cannot be smaller than 1");
        }
        this.numberOfEngines = numberOfEngines;
    }
}
