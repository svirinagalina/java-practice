class Commodity {
    private String name;
    private int price;

    public Commodity() {
        this.name = "";
        this.price = 0;
    }

    public Commodity(String name, int price) {
        this.name = name;
        this.price = price;
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

    public void setPrice(int Price) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name + ";" + price;
    }
}//put your code here
