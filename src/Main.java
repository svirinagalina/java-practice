import java.util.Scanner;

public class Main {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int score = scanner.nextInt();
    int newLimit = scanner.nextInt();
    scanner.nextLine(); // съедаем остаток строки

    Trial.setPassingScore(score);
    StrongTrial.setLimit(newLimit);

    int n = scanner.nextInt();
    scanner.nextLine();

    Trial[] trials = new Trial[n];
    for (int i = 0; i < trials.length; i++) {
        String[] items = scanner.nextLine().split(" ");
        int type = Integer.parseInt(items[0]);
        String surname = items[1];
        int score1 = Integer.parseInt(items[2]);
        int score2 = Integer.parseInt(items[3]);

        if (type == 1) {
            trials[i] = new Trial(surname, score1, score2);
        } else if (type == 2) {
            trials[i] = new LightTrial(surname, score1, score2);
        } else if (type == 3) {
            int time = Integer.parseInt(items[4]);
            trials[i] = new StrongTrial(surname, score1, score2, time);
        }
    }

    for (Trial trial : trials) {
        System.out.println(trial);
    }

    System.out.println();

    for (Trial trial : trials) {
        if (trial.isPassed()) {
            System.out.println(trial);
        }
    }
}
}
