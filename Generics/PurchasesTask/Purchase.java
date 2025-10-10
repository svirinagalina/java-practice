package PurchasesTask;

public class Purchase {
    private String name;
    private int priceKop;
    private int qty;

    public Purchase(String name, int priceKop, int qty) {
        this.name = name;
        this.priceKop = priceKop;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceKop() {
        return priceKop;
    }

    public void setPriceKop(int priceKop) {
        this.priceKop = priceKop;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
