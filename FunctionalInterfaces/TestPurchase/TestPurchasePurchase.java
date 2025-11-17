package FunctionalInterfaces.TestPurchase;

public class TestPurchasePurchase {
    String name;
    int price;
    int qty;

    public TestPurchasePurchase(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + qty + ";" + getCost();

    }

    public int getCost() {
        return price * qty;

    }

}
