package model;

import java.util.List;
import java.util.Map;

public class Game {
    Board board;
    List<Player> players;
    GameStatus gameStatus;
    Player winner;
    int currentPlayerNo;

    public Game(Map<Integer, Integer> jumps, List<String> playerNames) {
        this.board = new Board(jumps);
        this.players = Player.initializePlayers(playerNames);
        this.gameStatus = GameStatus.ACTIVE;
        this.currentPlayerNo = 0;
    }

    public void updateGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerNo);
    }

    public int getJumpCell(int cellId) {
        return board.getJumpCell(cellId);
    }

    public void updatePlayerTurn() {
        this.currentPlayerNo = (this.currentPlayerNo + 1) % this.players.size();
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
