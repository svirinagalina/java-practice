package UniversalStack;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Student> stack = new Stack<>(10);

        while(true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("конец")) {
                break;
            }

            String[] parts = line.split(" ");
            if (parts.length == 3) {
                String surname = parts[0];
                double averageMark = Double.parseDouble(parts[1]);
                int age = Integer.parseInt(parts[2]);

                Student st = new Student(surname, averageMark, age);
                try {
                    stack.push(st);
                } catch (StackException e) {
                    System.out.print(e.getMessage());
                    return;
                }
            }
        }
        try {
            stack.printReverse();
        } catch (StackException e) {
            System.out.print(e.getMessage());
        }

        //put your code here
    }
}
