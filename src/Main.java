import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("ERROR");
            return;
        }
        scanner.skip("\n");

        BusinessTrip[] trips = new BusinessTrip[n];
        for (int i = 0; i < trips.length - 1; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String surname = parts[0];
            int days = Integer.parseInt(parts[1]);
            int transport = Integer.parseInt(parts[2]);

            trips[i] = new BusinessTrip(surname, days, transport);
        }
        trips[trips.length - 1] = new BusinessTrip(trips[0]);

        String newSurname = scanner.nextLine();
        trips[0].setSurname(newSurname);

        for (int i = 0; i < trips.length; i++) {
            System.out.println(trips[i]);
        }
        System.out.println();

        int index = scanner.nextInt();

        BusinessTrip target = trips[index];

        for (BusinessTrip trip : trips) {
            if (trip.equals(target)){
                System.out.println(trip);
            }
        }


        //put your code here
    }
}