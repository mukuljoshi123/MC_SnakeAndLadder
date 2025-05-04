package optput;

import model.Player;

public interface Printer {

    void printMove(Player currentPlayer, int diceScore, int finalPosition);

    void printWin(Player currentPlayer);

    void gameEnded();

}
