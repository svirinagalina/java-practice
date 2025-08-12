package cars;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        Car[] cars = new Car[size];
        for (int i=0; i < cars.length; i++) {
            String[] line = scanner.nextLine().split(" ");
            String brand = line[0];
            String owner = line[1];
            double volume = Double.parseDouble(line[2]);
            int yearOfMake = Integer.parseInt(line[3]);

            cars[i] = new Car(brand, owner, volume, yearOfMake);
        }

            int index = scanner.nextInt();
            double newVolume = scanner.nextDouble();

        if (index >= 1 && index <= cars.length) {
            cars[index - 1].setVolume(newVolume);
        }

        for (Car c : cars) {
                System.out.println(c);
            }
            System.out.println();

        Car newest = cars[0];

        for (int i = 1; i < cars.length; i++) {
            if (cars[i].getLife() < newest.getLife()) {
                newest = cars[i];
            }
        }// найти самую новую
System.out.println("Newest" + newest);
    }
}
