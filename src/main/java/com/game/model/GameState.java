package com.game.model;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class GameState {
    ArrayDeque<Player> playerTurnQueue;
    Map<Player, Integer> playerPosition = new HashMap<>();
    int rollValue;
    boolean isClimb= false;
    boolean isSlide= false;

    public GameState(ArrayDeque<Player> playerTurnQueue, Map<Player, Integer> playerPosition, int rollValue, boolean isClimb, boolean isSlide) {
        this.playerTurnQueue = playerTurnQueue.clone();
        this.playerPosition.putAll(playerPosition);
        this.rollValue = rollValue;
        this.isClimb = isClimb;
        this.isSlide = isSlide;
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

    public boolean isClimb() {
        return isClimb;
    }

    public boolean isSlide() {
        return isSlide;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "playerTurnQueue=" + playerTurnQueue.toString() +
                ", playerPosition=" + playerPosition.toString() +
                ", rollValue=" + rollValue +
                '}';
    }
}
