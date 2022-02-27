package com.game.model;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class GameState {
    ArrayDeque<Player> playerTurnQueue;
    Map<Player, Integer> playerPosition = new HashMap<>();
    int rollValue;

    public GameState(ArrayDeque<Player> playerTurnQueue, Map<Player, Integer> playerPosition, int rollValue) {
        this.playerTurnQueue = playerTurnQueue.clone();
        this.playerPosition.putAll(playerPosition);
        this.rollValue = rollValue;
    }

    public ArrayDeque<Player> getPlayerTurnQueue() {
        return playerTurnQueue;
    }

    public Map<Player, Integer> getPlayerPosition() {
        return playerPosition;
    }

    public int getRollValue() {
        return rollValue;
    }

    public String printPlayerPosition() {
        StringBuilder printPlayerPosition= new StringBuilder();
        playerPosition.forEach((player, pos) -> {
           printPlayerPosition.append(player.getName() + " :" + pos +  "\t");
        });
        return printPlayerPosition.toString();
    }

    public String printPlayerQueue() {
        StringBuilder printPlayerQueue = new StringBuilder();
        playerTurnQueue.forEach(player ->  printPlayerQueue.append(player.getName() + "\t"));
        return printPlayerQueue.toString();
    }

    @Override
    public String toString() {
        return "GameState{" +
                "playerTurnQueue=" + printPlayerQueue()+
                ", playerPosition=" + printPlayerPosition() +
                ", rollValue=" + rollValue +
                '}';
    }
}
