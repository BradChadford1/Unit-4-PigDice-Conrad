public class Turn {
    private int currentPlayerTurn;

    public Turn() {
        currentPlayerTurn = 1;
    }

    public void passTurn() {
        currentPlayerTurn++;
    }

    public boolean isOdd() {
        if (currentPlayerTurn%2 == 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
