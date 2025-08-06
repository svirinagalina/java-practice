public class Trial {
    private static int passingScore;

    private String surname;
    private int score1;
    private int score2;

    public Trial() {
        this.surname = "";
        this.score1 = 0;
        this.score2 = 0;
    }

    public Trial(String surname) {
        this.surname = surname;
    }

    public Trial(String surname, int score1, int score2) {
        this.surname = surname;
        this.score1 = score1;
        this.score2 = score2;
    }

    public static int getPassingScore() {
        return passingScore;
    }

    public static void setPassingScore(int score) {
        passingScore = score;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public boolean isPassed() {
        return score1 >= passingScore && score2 >= passingScore;
    }

    public String toString() {
        return surname + ";" + score1 + ";" + score2;
    }
}
