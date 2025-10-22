package StandardInterfaces.Commodity;

public class Commodity {
    private String name;
    private int price;
    private String country;

    @Override
    public String toString() {
        return name + ";" + price + ";" + country;
    }

    public Commodity(String name, int price, String country) {
        this.name = name;
        this.price = price;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
