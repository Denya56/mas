package ordered;


public class Car {
    private String color;
    private Train train;

    public Car(String color) {
        setColor(color);
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        if(color == null || color.isBlank()) {
            throw new IllegalArgumentException("Color has to be specified");
        }
        this.color = color;
    }

    public Train getTrain() {
        return train;
    }

    public void addTrain(Train train) {
        if(train == null) {
            throw new IllegalArgumentException("Train cannot be null");
        }
        if(this.train.equals(train)) return;
        this.train = train;
        train.addCar(this);
    }

    public void removeTrain(Train train) {
        if(train == null) {
            throw new IllegalArgumentException("Train cannot be null");
        }
        if(!this.train.equals(train)) return;
        this.train = null;
        train.removeCar(this);
    }

    public static void delete(Car car) {
        if(car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        car.train.removeCar(car);
        car.train = null;
        //extent.remove(player);
    }
}
