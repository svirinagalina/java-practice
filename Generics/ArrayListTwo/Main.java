package ArrayListTwo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> adult = new ArrayList<>();
        ArrayList<Student> underAge = new ArrayList<>();
String line = scanner.nextLine();

        while (!"end".equals(line)) {
            String[] parts = line.split(" ");
Student student = new Student(parts[0],
        Double.parseDouble(parts[1]),
        Integer.parseInt(parts[2]));

            if (student.getAge() >= 18) {
                adult.add(student);
            } else {
                underAge.add(student);
            }

            line = scanner.nextLine(); // читаем следующего студента
        }
        if (underAge.isEmpty()) {
            System.out.println("Пустой список");
        } else {
            System.out.println(underAge);
        }


        if (adult.isEmpty()) {
            System.out.println("Пустой список");
        } else {
            System.out.println(adult);
        }

        scanner.close();
    }
}