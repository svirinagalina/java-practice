import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Pet[] pets = new Pet[n];

        for (int i = 0; i < n; i++) {
            String[] name = scanner.nextLine().trim().split("\\s+");
            int type = Integer.parseInt(name[0]);
            String nickname = name[1];
            int age = Integer.parseInt(name[2]);
            if (type == 1) {
                String breed = name[3];
                pets[i]  = new Dog(nickname, age, breed);
            } else if (type == 2) {
                String color = name[3];
                pets[i] = new Cat(nickname, age, color);

            }else { i--; continue; }
        }

        for (Pet pet : pets) {
            System.out.print(pet.getClass().getSimpleName() + " " + pet.getNickname() + ":");
            pet.getNoise();
        }
        System.out.println();

        for (Pet pet : pets) {
            if (pet instanceof Cat) {
                System.out.println(pet);
            }

        }
    }
}
