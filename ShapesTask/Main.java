import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        IShape[] shapes = new IShape[n];

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int type = Integer.parseInt(parts[0]);
            if (type == 1) {
                double side1 = Double.parseDouble(parts[1]);
                double side2 = Double.parseDouble(parts[2]);

                shapes[i] = new Rectangle(side1, side2);
            } else if (type == 2) {
                double side1 = Double.parseDouble(parts[1]);

                shapes[i] = new Cube(side1);
            }
        }

        for (IShape shape : shapes) {
            System.out.printf("%.2f ", shape.computerSquare());
        }


        double max = 0;
        Rectangle biggest = null;

        for (IShape shape : shapes) {
            if (shape instanceof Rectangle) {
                Rectangle rect =  (Rectangle) shape;
                double area = rect.computerSquare();

                if (area > max) {
                    max = area;
                    biggest = rect;
                }
            }
        }

if (biggest != null) {
    System.out.printf("Прямоугольник сторона 1 = %.2f, сторона 2 = %.2f Площадь = %.2f%n", biggest.getSide1(), biggest.getSide2(), biggest.computerSquare());
} else  {
    System.out.println("ERROR");

}
                    }
                }
