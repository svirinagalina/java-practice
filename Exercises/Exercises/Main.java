package Exercises;

public class Main {
    public static void main(String[] args) {
        int a = 5;   // 0101
        int b = 3;   // 0011

        int result = a & b; // побитовое И

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a & b = " + result); // выведет 1
    }
}
