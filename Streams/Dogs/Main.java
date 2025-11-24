package Streams.Dogs;

import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
List <Dog> dogs = new ArrayList<>();

while(true) {
    String line = scanner.nextLine();
    if (line.equals("end")) break;

    String[] parts = line.split(" ");
if (parts.length == 2) {
    dogs.add(new Dog(parts[0], parts[1]));
} else if (parts.length == 4) {
    Collar collar = new Collar(parts[2], Integer.parseInt(parts[3]));
    dogs.add(new Dog(parts[0], parts[1], collar));
}

}

List <Collar> collars = dogs.stream()
        .map(Dog::getCollar)
        .filter(Objects::nonNull)
        .sorted(Comparator.comparing(Collar::getQty))
        .toList();


System.out.println(collars);
    }
}
