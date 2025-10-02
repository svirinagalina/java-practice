package CreatingStack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите размер стека");
            int size = scanner.nextInt();

            Stack stack = new Stack(size);

            while (true) {
                System.out.println("Меню:");
                System.out.println("1 - добавить символ в стек");
                System.out.println("2 - удалить символ из стека");
                System.out.println("3 - распечатать стек");
                System.out.println("4 - очистить стек");
                System.out.println("5 - выход");
                System.out.print("Ваш выбор: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Некоректный ввод данных!");
                    System.exit(0);
                }

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Введите символ: ");
                        char c = scanner.next().charAt(0);
                        stack.push(c);
                        break;
                    case 2:
                        stack.pop();
                        break;
                    case 3:
                        stack.print();
                        break;
                    case 4:
                        stack.clear();
                        System.out.println("Стек очищен.");
                        break;
                    case 5:
                        System.out.println("Выход из программы...");
                        return;
                    default:
                        System.out.println("Некорректный ввод данных");
                        System.exit(0);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Некорректный ввод данных!");
            System.exit(0);
        }

    }
}
