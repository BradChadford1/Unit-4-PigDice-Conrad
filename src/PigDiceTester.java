public class PigDiceTester {
    public static void main(String[] args) {
        GamePlay p1 = new GamePlay();
        GamePlay p2 = new GamePlay();

        p1.rollToScore();

        System.out.println(p1.d1ToString() + " and " + p1.d2ToString());
        System.out.println(p1.getSubScore() + " and " + p1.getTotalScore());

        p2.rollToScore();
        System.out.println(p1.d1ToString() + " and " + p1.d2ToString());
        p1.pass();
        System.out.println(p1.getTotalScore());
    }
}