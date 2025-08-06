public class LightTrial extends Trial {
    public LightTrial(String surname, int score1, int score2) {
        super(surname, score1, score2);
    }

    @Override
    public boolean isPassed() {
        return (getScore1() + getScore2()) >= getPassingScore();
    }
}
