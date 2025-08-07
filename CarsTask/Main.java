package CarsTask;

import java.util.Scanner;
import java.util.Calendar;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Car[] cars = new Car[n];
        for (int i = 0; i < cars.length; i++) {
            String[] line = scanner.nextLine().split(" ");
            int type = Integer.parseInt(line[0]);
            String brand = line[1];
            String surname = line[2];
            double volume = Double.parseDouble(line[3]);
            int yearOfMake = Integer.parseInt(line[4]);

            if (type == 1) {
                cars[i] = new Car(brand, surname, volume, yearOfMake);
            } else if (type == 2) {
                double capacity = Double.parseDouble(line[5]);
                cars[i] = new Truck(brand, surname, volume, yearOfMake, capacity);
            }
        }

        for (Car c : cars) {
            System.out.println(c);
        }
        System.out.println();

        double weight = scanner.nextDouble();

        boolean found = false;
        for (Car car: cars) {
            if (car instanceof Truck) {
                Truck truck = (Truck) car;
                if(truck.getLife() <= 7 && truck.ifCanCarry(weight)) {
                    System.out.println(truck);
                    found = true;

                }
            }
        }
        if (!found) {
            System.out.println("NO");
        }
        scanner.close();
    }
}