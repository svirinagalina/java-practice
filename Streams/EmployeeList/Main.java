package Streams.EmployeeList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.equals("end")) break;
String[] parts = line.split(" ");

            employees.add(new Employee(parts[0], parts[1], Double.parseDouble(parts[2])));

        }
        Comparator<Employee> comparator = Comparator.comparing(Employee::getLastName)

                .thenComparing(Employee::getSalary);
employees.stream()
                .sorted(comparator)
       .forEach(System.out::println);
    }
}
