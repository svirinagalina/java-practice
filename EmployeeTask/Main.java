package EmployeeTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n == 0) {
            return;
        }

        Employee[] employees = new Employee[n];

        for (int i = 0; i < employees.length; i++) {
            String[] line = scanner.nextLine().split("\\s+");

            int type = Integer.parseInt(line[0]);
            String surname = line[1];
            String gender = line[2];
            int age = Integer.parseInt(line[3]);
            int salary = Integer.parseInt(line[4]);

            switch (type) {
                case 1:
                    employees[i] = new Employee(surname, gender, age, salary);
                    break;
                case 2:
                    String status = line[5];
                    String specialization = line[6];
                    employees[i] = new Programmer(surname, gender, age, salary, status, specialization);
                    break;
                case 3:
                    char gruppa = line[5].charAt(0);
                    employees[i] = new Accountant(surname, gender, age, salary, gruppa);
                    break;
            }
        }

        for (Employee e : employees) {
            e.show();
        }
        int totalSalary = calculateTotalSalary(employees);
        System.out.println(totalSalary);

        int maxSalary = findMaxSalary(employees);
        for (Employee emp : employees) {
            if (emp.getSalary() == maxSalary) {
                emp.show();
                break;
            }
        }
        System.out.println();

        boolean foundFrontend = false;
        for (Employee emp : employees) {
            if (emp instanceof Programmer) {
                Programmer prog = (Programmer) emp;
                if (prog.getSpecialization().equalsIgnoreCase("frontend")) {
                    prog.show();
                    foundFrontend = true;
                }
            }
        }

        if (!foundFrontend) {
            System.out.println("NO");
        }
    }

    public static int calculateTotalSalary(Employee[] employees) {
        int sum = 0;
        for (Employee emp : employees) {
            sum += emp.getSalary();
        }
        return sum;
    }

    public static int findMaxSalary(Employee[] employees) {
        int max = 0;
        for (Employee emp : employees) {
            if (emp.getSalary() > max) {
                max = emp.getSalary();

            }
        }
        return max;
    }

}
