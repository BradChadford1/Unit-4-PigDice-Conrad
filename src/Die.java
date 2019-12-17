public class Die {
    private int face;
    private int sides;

    public Die(int numSides) {
        sides = numSides;
    }

    public int getFace() {
        return face;
    }

    public void roll() {
        face = (int)(Math.random() * sides + 1);

    }

    public String toString() {
        return "You rolled a " + face;
    }

    public boolean isOne() {
        if (face == 1)
            return true;
        else
            return false;
    }
}