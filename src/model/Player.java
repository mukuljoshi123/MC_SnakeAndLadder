package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition=  0;
    }

    public static List<Player> initializePlayers(List<String> playerNames) {
        List<Player> players = new ArrayList<Player>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        return players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
