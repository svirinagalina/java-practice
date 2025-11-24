package Streams.Purchases;

import java.util.Objects;

public class Commodity {
    private String name;
    private int price;

    public Commodity(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return price == commodity.price && Objects.equals(name, commodity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
