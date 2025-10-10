package ParametrizedClasses;

import java.util.Objects;

public class Purchase {
    private String name;
    private int price;
    private int qty;

    public Purchase(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + qty + ";";
    }

    @Override

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return price == purchase.price && qty == purchase.qty && Objects.equals(name, purchase.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, qty);
    }
}
