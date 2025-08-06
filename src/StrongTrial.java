public class StrongTrial extends Trial {
    private int time;
    private static int limit;

    public StrongTrial(String surname, int score1, int score2, int time) {
        super(surname, score1, score2);
        this.time = time;
    }

    public static int getLimit() {
        return limit;
    }

    public static void setLimit(int newLimit) {
        limit = newLimit;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean isPassed() {
        return getScore1() >= getPassingScore() &&
                getScore2() >= getPassingScore() &&
                time <= limit;
    }

    @Override
    public String toString() {
        return getSurname() + ";" + getScore1() + ";" + getScore2() + ";" + time;
    }
}
