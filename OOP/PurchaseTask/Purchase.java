class Purchase {

    private int quantity;

    private Commodity commodity;

    public Purchase() {
        this.quantity = 0;
    }

    public Purchase(Commodity commodity, int quantity) {
        this.commodity = commodity;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return commodity.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return commodity.getName() + ";" + commodity.getPrice() + ";" + quantity + ";" + getCost();
    }

    //put your code here
}