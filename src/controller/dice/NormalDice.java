package controller.dice;

import java.util.Random;

public class NormalDice implements Dice {
    @Override
    public int roll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
