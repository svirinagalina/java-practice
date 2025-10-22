package StandardInterfaces.Numbers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

List<Integer> list = new ArrayList<>();

while(true) {
    String line = scanner.nextLine().trim();
    if (line.equalsIgnoreCase("end")){
        break;
    }
    try {
        int num = Integer.parseInt(line);
        list.add(num);
    } catch (Exception e) {
    }
}
if (list.isEmpty()) {
    return;
}

if(list.size() >= 3) {
int middleIndex = list.size()/2;
int newValue = list.get(0) + list.size()- 1;
list.set(middleIndex, newValue);
}
System.out.println(list);
    }
}
