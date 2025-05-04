package optput;

import model.Player;

public class GamePrinter implements Printer{

    public void printMove(Player currentPlayer,int diceScore,int finalPosition){
        System.out.println(currentPlayer.getName() + " rolled a " + diceScore + " and moved from " + currentPlayer.getCurrentPosition() + " to " + finalPosition);
    }

    public void printWin(Player currentPlayer){
        System.out.println(currentPlayer.getName() + " wins the game");
    }

    public void gameEnded(){
        System.out.println("game has ended.");
    }
}
