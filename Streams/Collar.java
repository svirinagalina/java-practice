package Streams;

class Collar {
    String color;
    int qty;

    public Collar(String color, int qty) {
        this.color = color;
        this.qty = qty;
    }

    public String getColor() {
        return color;
    }

    public int getQty() {
        return qty;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
public String toString() {
        return color + ";" + qty + ";";
}

}
