import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Transport[] transports = new Transport[n];
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int type = Integer.parseInt(parts[0]);

            if (type == 1) {
                double capacity = Double.parseDouble(parts[1]);
                transports[i] = new Lorry(capacity);
            } else if (type == 2) {
                double capacity = Double.parseDouble(parts[1]);
                transports[i] = new Ship(capacity);
            }
        }

        double weight = scanner.nextDouble();
        for (Transport transport : transports) {
            if (transport.canCarry(weight)) {
                transport.add(weight);
            }
        }
        for (Transport transport : transports) {
        System.out.println(transport);
        }
    }

}
