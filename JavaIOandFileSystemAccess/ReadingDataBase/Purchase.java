package ReadingDataBase;

public class Purchase {

    public final int price;
    public final String name;
    public final double qty;

    public Purchase(String name, int price, double qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public double cost() {
        return price * qty;
    }
    private static boolean isInt(String s) {
        return s != null && s.matches("[+-]?\\d+");
    }

    private static boolean isDoubleDot(String s) {
        // только с точкой как разделителем дробной части
        return s != null && s.matches("[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)");
    }
}

