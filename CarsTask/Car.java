package CarsTask;

class Car {
    private String brand;
    private String owner;
    private double volume;
    private int yearOfMake;

    private static int yearNow;

    static  {
        Calendar cal = Calendar.getInstance(); //не забыть импортировать класс java.util.Calendar!
        yearNow = cal.get(Calendar.YEAR);
    }

    public Car() {
        this.owner = "";
        this.brand = "";
        this.volume = 0.0;
        this.yearOfMake = 0;
    }

    public Car(String brand, String owner, double volume, int yearOfMake) {
        this.owner = owner;
        this.brand = brand;
        this.volume = volume;
        this.yearOfMake = yearOfMake;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getYearOfMake() {
        return yearOfMake;
    }
    public void setYearOfMake(int yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public int getLife() {
        return yearNow - yearOfMake;
    }

    @Override
    public String toString() {
        return "Car{brand='" + brand + "', owner='" + owner + "', volume="  + volume + ", yearOfMade=" + yearOfMake + "}";
    }
}