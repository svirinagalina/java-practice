import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte maxQuantity = 10;
        Parking parking = new Parking(maxQuantity);
        Scanner scanner = new Scanner(System.in);
        byte quantity = scanner.nextByte();

        System.out.println("Приехали на парковку");

        try {
            parking.check(quantity);
            System.out.println("Припарковались");
        } catch (TooManyCarsException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Припарковались в другом месте");
        } finally {
            System.out.println("Выходим из машин");
        }

    }
}
