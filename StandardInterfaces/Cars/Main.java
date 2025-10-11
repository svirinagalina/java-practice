package StandardInterfaces.Cars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ErrorBoxException {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Garage garage = new Garage(size);

        while (true) {
            int command = scanner.nextInt();

            if (command == 1) {
                String brand = scanner.next();
                double volume = scanner.nextDouble();
                int boxNumber = scanner.nextInt();

                garage.putCar(new Car(brand, volume), boxNumber);
            } else if (command == 2) {
                int boxNumber = scanner.nextInt();
                try {
                    Car car = garage.getCar(boxNumber);
                    System.out.println(car);
                } catch (ErrorBoxException e) {
                    System.out.println("ERROR");
                }
            } else if (command == 3) {
                System.out.println("----------------");
                for (Car car : garage) {
                    System.out.println(car);
                }
                System.out.println("----------------");

            } else {
                break;
            }
        }
    }
}
