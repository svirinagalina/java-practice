package DataStructures;

import java.util.Objects;

public class Purchases {
    private String name;
    private String country;
    private double price;

    public Purchases(String name, String country, double price) {
        this.name = name;
        this.country = country;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Purchases purchases = (Purchases) o;
        return Double.compare(price, purchases.price) == 0 &&
                Objects.equals(name, purchases.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
