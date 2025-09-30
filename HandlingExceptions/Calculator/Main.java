package Calculator;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int opPos = -1;
        char op = 0;
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
                opPos = i;
                op = c;
                break;
            }
        }
        if (opPos == -1) {
            System.out.println("Error");
            return;
        }
        try {
            String left = input.substring(0, opPos);
            String right = input.substring(opPos + 1);

            if (left.isEmpty() || right.isEmpty()) {
                System.out.println("Error");
                return;
            }

            int a = Integer.parseInt(left);
            int b = Integer.parseInt(right);

            if ((op == '/' || op == '%') && b == 0) {
                System.out.println("Error");
                return;
            }
            if (!left.matches("\\d+") || !right.matches("\\d+")) {
                System.out.println("Error");
                return;
            }
            switch (op) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    result = a / b;
                    break;
                case '%':
                    result = a % b;
                    break;

            }
            System.out.println(a + "" + op + "" + b + "" + "=" + result);    //put your code here
        } catch (Exception e) {
            System.out.println("Error");
            return;
        }
        scanner.close();
    }
}
