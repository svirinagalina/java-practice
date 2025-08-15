public class Rectangle implements IShape{
    private double side1;
    private double side2;

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide1(double side1) {}

    public Rectangle(double side1,double side2){
        this.side1=side1;
        this.side2=side2;
    }

    @Override
    public double computerSquare() {
        return side1 * side2;
    }
}

