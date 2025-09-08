package NumbersTask;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seed = scanner.nextInt();
        Random random = new Random(seed);
        int n = random.nextInt(1, 11);
        int[] arr = new int[n];


        for (
                int i = 0;
                i < 3; i++) {
            int index = scanner.nextInt();
            int value = scanner.nextInt();

            try {
                arr[index] = value;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Индекс не попал в массив");
            }
        }


        System.out.println(Arrays.toString(arr));
    }
}

