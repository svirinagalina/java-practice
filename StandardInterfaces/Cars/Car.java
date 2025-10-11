package StandardInterfaces.Cars;

public class Car {
    private String brand;
    private double volume;

    public Car(String brand, double volume) {
        this.brand = brand;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return brand + ";" + volume;
    }
}
