import model.Game;
import model.GameStatus;
import model.Ladder;
import model.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to snake and ladder game");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of snakes");
        int noOfSnakes = scanner.nextInt();
        scanner.nextLine();
        List<Snake> snakes = new ArrayList<>();
        for (int i = 1; i <= noOfSnakes; i++) {
            String[] line = scanner.nextLine().split(" ");
            snakes.add(new Snake(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        List<Ladder> ladders = new ArrayList<>();
        System.out.println("Enter Number of ladders");
        int noOfLadders = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= noOfLadders; i++) {
            String[] line = scanner.nextLine().split(" ");
            ladders.add(new Ladder(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        System.out.println("Enter no of Players");
        int noOfPlayers = scanner.nextInt();
        scanner.nextLine();
        List<String> playerNames = new ArrayList<>();
        for (int i = 1; i <= noOfPlayers; i++) {
            String name = scanner.nextLine();
            playerNames.add(name);
        }
        Game game = new Game(snakes, ladders, playerNames);
        while (!game.getGameStatus().equals(GameStatus.ENDED)) {
            game.makeMove();
        }
    }
}