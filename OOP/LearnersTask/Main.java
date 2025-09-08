package learners;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int baseScholarship = scanner.nextInt();
        scanner.nextLine();

        Student.setBaseScholarship(baseScholarship);

        int n = scanner.nextInt();
        Learner[] learners = new Learner[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }           // на случай пустой строки
            String[] parts = line.split("\\s+");                  // делим по одному/нескольким пробелам

            int type = Integer.parseInt(parts[0]);
            String surname = parts[1];
            int mark1 = Integer.parseInt(parts[2]);
            int mark2 = Integer.parseInt(parts[3]);

            if (type == 1) {
                String school = parts[4];
                String grade = parts[5];
                learners[i] = new SchoolBoy(surname, mark1, mark2, school, grade);
            } else if (type == 2) {
                String university = parts[4];
                String group = parts[5];
                learners[i] = new Student(surname, mark1, mark2, university, group);
            } else {
                // неизвестный тип — просто повторим ввод для этой позиции
                i--;
            }
        }

        for (Learner learner : learners) {
            System.out.println(learner + " каникулы: " + learner.holidays());
        }

        double avgMrk = 0;
        for (Learner learner : learners) {
            avgMrk += learner.averageGrade();
            System.out.printf("%.1f%n", avgMrk / learners.length);
        }

        int totalScholarship = 0;
        boolean hasStudents = false;
        for (Learner l : learners) {
            if (l instanceof Student) {
                hasStudents = true;
                Student s = (Student) l;
                System.out.println(s);
                totalScholarship += s.calculateScholarship();
            }
        }
        if (hasStudents) {
        System.out.println(totalScholarship);
        } else {
            System.out.println("NO");
        }
    }
    }