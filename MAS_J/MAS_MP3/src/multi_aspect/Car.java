package multi_aspect;

public class Car extends Vehicle{
    private String numberOfWheels;

    public Car(String name, double horsepower, EngineType engineType, int numberOfPistons, String jetFuelType, String numberOfWheels) {
        super(name, horsepower, engineType, numberOfPistons, jetFuelType);
        setNumberOfWheels(numberOfWheels);
    }

    public String getNumberOfWheels() {
        return numberOfWheels;
    }

    private void setNumberOfWheels(String numberOfWheels) {
        if(numberOfWheels == null || numberOfWheels.isBlank())
        {
            throw new IllegalArgumentException("Number of wheels must be specified");
        }
        this.numberOfWheels = numberOfWheels;
    }
}
