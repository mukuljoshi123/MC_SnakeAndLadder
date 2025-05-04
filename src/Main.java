import controller.dice.Dice;
import controller.dice.NormalDice;
import model.Game;
import model.Ladder;
import model.Snake;
import optput.GamePrinter;
import optput.Printer;
import service.GameService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to snake and ladder game");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of snakes");
        int noOfSnakes = scanner.nextInt();
        Dice dice = new NormalDice();
        scanner.nextLine();
        Map<Integer, Integer> jumps = new HashMap<>();
        for (int i = 1; i <= noOfSnakes; i++) {
            String[] line = scanner.nextLine().split(" ");
            Snake snake = new Snake(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            jumps.put(snake.getStart(), snake.getEnd());
        }
        System.out.println("Enter Number of ladders");
        int noOfLadders = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= noOfLadders; i++) {
            String[] line = scanner.nextLine().split(" ");
            Ladder ladder = new Ladder(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            jumps.put(ladder.getStart(), ladder.getEnd());
        }

        System.out.println("Enter no of Players");
        int noOfPlayers = scanner.nextInt();
        scanner.nextLine();
        List<String> playerNames = new ArrayList<>();
        for (int i = 1; i <= noOfPlayers; i++) {
            String name = scanner.nextLine();
            playerNames.add(name);
        }
        Game game = new Game(jumps, playerNames);
        Printer gamePrinter = new GamePrinter();
        GameService gameService = new GameService(game, gamePrinter, dice);
        gameService.startGame();
    }
}