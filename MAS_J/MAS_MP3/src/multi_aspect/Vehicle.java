package multi_aspect;

public abstract class Vehicle {
    private String name;
    private double horsepower;
    private EngineType engineType;
    private int numberOfPistons;
    private String jetFuelType;

    public Vehicle(String name, double horsepower, EngineType engineType, int numberOfPistons, String jetFuelType) {
        setName(name);
        setHorsepower(horsepower);
        setEngineType(engineType);
        if(engineType.equals(EngineType.PISTON)) this.numberOfPistons = numberOfPistons;
        if(engineType.equals(EngineType.JET)) this.jetFuelType = jetFuelType;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name must be specified");
        }
        this.name = name;
    }

    public double getHorsepower() {
        return horsepower;
    }

    private void setHorsepower(double horsepower) {
        if(horsepower <= 0)
        {
            throw new IllegalArgumentException("Horsepowe cannot be smaller than 1");
        }
        this.horsepower = horsepower;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    private void setEngineType(EngineType engineType) {
        if(engineType == null) {
            throw new IllegalArgumentException("Engine type cannot be null");
        }
        this.engineType = engineType;
    }

    public int getNumberOfPistons() {
        return numberOfPistons;
    }

    private void setNumberOfPistons(int numberOfPistons) {
        if(numberOfPistons <= 0)
        {
            throw new IllegalArgumentException("Number of pistons cannot be smaller than 1");
        }
        this.numberOfPistons = numberOfPistons;
    }

    public String getJetFuelType() {
        return jetFuelType;
    }

    private void setJetFuelType(String jetFuelType) {
        if(jetFuelType == null || jetFuelType.isBlank())
        {
            throw new IllegalArgumentException("Jet fuel type must be specified");
        }
        this.jetFuelType = jetFuelType;
    }
}
