package Streams.StudentGroups;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("end")) break;

            String[] parts = line.split(" ");

            students.add(new Student(parts[0], parts[1], Integer.parseInt(parts[2])));

        }

        Map<String, List<Student>> map = students.stream()

                .collect(Collectors.groupingBy(Student::getGruppa));

        map.forEach((group, list) ->  {
            System.out.println(group + ":");
            System.out.println(list);
        });
    }
}