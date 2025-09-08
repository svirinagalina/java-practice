import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();

        Cook pastry = new Cook();

        try {
            pastry.turnOvenOn();
            pastry.bake(product);
            System.out.println("The pastry is ready");

        } catch (BakingException ex) {
            System.out.println("The pastry cannot be baked: " + ex.getMessage());

        } finally {
            pastry.turnOvenOff();

        }
    }
}
