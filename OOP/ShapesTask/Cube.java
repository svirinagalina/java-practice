public class Cube implements IShape {

    private double side1;

    public Cube(double side1) {
        this.side1 = side1;
    }

    @Override
    public double computerSquare() {
        return 6 * side1 * side1;
    }
}
