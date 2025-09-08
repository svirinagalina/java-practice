package CarsTask;

class Truck extends Car {

    private double capacity;

    public Truck() {
        super();
        this.capacity = 0.0;

    }

    public Truck(String brand, String owner, double volume, int yearOfMake, double capacity) {
        super (brand, owner, volume, yearOfMake);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public boolean ifCanCarry(double weight) {
        return capacity >= weight;
    }

    @Override
    public String toString() {
        return "Truck{brand='" + getBrand() + "', owner='" + getOwner() + "', volume=" + getVolume() + ", yearOfMade=" + getYearOfMake() + ", capacity=" + getCapacity() + "}";
    }

}