package model;

import java.util.List;

public class Game {
    Board board;
    List<Player> players;
    GameStatus gameStatus;
    Player winner;
    int currentPlayerNo;

    public Game(List<Snake> snakes, List<Ladder> ladders, List<String> playerNames) {
        this.board = new Board(snakes, ladders);
        this.players = Player.initializePlayers(playerNames);
        this.gameStatus = GameStatus.ACTIVE;
        this.currentPlayerNo = 0;
    }

    public void makeMove() {
        int diceScore = Dice.rollDice();
        Player currentPlayer = players.get(currentPlayerNo);
        int finalPosition = this.board.snakeBite(new Cell(currentPlayer.currentPosition + diceScore));
        if (finalPosition > 100) finalPosition = currentPlayer.currentPosition;
        if (finalPosition == 100) {
            this.gameStatus = GameStatus.ENDED;
            this.winner = currentPlayer;
            System.out.println(currentPlayer.getName() + " rolled a " + diceScore + " and moved from " + currentPlayer.currentPosition + " to" + finalPosition);
            System.out.println(currentPlayer.getName() + " wins the game");
            return;
        }
        System.out.println(currentPlayer.getName() + " rolled a " + diceScore + " and moved from " + currentPlayer.currentPosition + " to" + finalPosition);
        currentPlayer.currentPosition = finalPosition;
        updatePlayerTurn();
    }

    private void updatePlayerTurn() {
        this.currentPlayerNo = (this.currentPlayerNo + 1 )% this.players.size();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getCurrentPlayerNo() {
        return currentPlayerNo;
    }

    public void setCurrentPlayerNo(int currentPlayerNo) {
        this.currentPlayerNo = currentPlayerNo;
    }
}
