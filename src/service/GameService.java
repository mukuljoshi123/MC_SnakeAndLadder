package service;

import controller.dice.Dice;
import model.Game;
import model.GameStatus;
import model.Player;
import optput.Printer;

public class GameService {

    public static final Integer WINNING_POSITION = 100;

    Game game;
    Printer gamePrinter;
    Dice dice;

    public GameService(Game game, Printer gamePrinter, Dice dice) {
        this.game = game;
        this.gamePrinter = gamePrinter;
        this.dice = dice;
    }

    public void startGame() {
        while (this.game.getGameStatus().equals(GameStatus.ACTIVE)) {
            makeMove();
        }
        gamePrinter.gameEnded();
    }

    public void makeMove() {
        int diceScore = dice.roll();
        Player currentPlayer = this.game.getCurrentPlayer();
        int finalPosition = this.game.getJumpCell(currentPlayer.getCurrentPosition() + diceScore);
        if (finalPosition > WINNING_POSITION) finalPosition = currentPlayer.getCurrentPosition();
        if (finalPosition == WINNING_POSITION) {
            this.game.updateGameStatus(GameStatus.ENDED);
            this.game.setWinner(currentPlayer);
            gamePrinter.printMove(currentPlayer, diceScore, finalPosition);
            gamePrinter.printWin(currentPlayer);
            return;
        }
        gamePrinter.printMove(currentPlayer, diceScore, finalPosition);
        currentPlayer.moveTo(finalPosition);
        this.game.updatePlayerTurn();
    }

}
