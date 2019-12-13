public class GamePlay {
    private int subScore;
    private int totalScore;
    private Die d1 = new Die(6);
    private Die d2 = new Die(6);

    public GamePlay() {
        subScore = 0;
        totalScore = 0;
    }

    public int getSubScore() {
        return subScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getD1() {
        return d1.getFace();
    }

    public int getD2() {
        return d2.getFace();
    }

    public String d1ToString() {
        return d1.toString();
    }

    public String d2ToString() {
        return d2.toString();
    }

    public void rollToScore() {
        d1.roll();
        d2.roll();
        if (d1.isOne() && d2.isOne())
            totalScore = 0;
        if (d1.isOne() || d2.isOne())
            subScore = 0;
        else
            subScore += d1.getFace() + d2.getFace();
    }

    public void pass() {
        totalScore += subScore;
    }

}
