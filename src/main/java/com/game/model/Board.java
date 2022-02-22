package com.game.model;

public class Board {
    int size;
    int startPosition = 0, endPosition;
    Snake [] snakes;
    Ladder [] ladders;


    public Board(int size, Snake[] snakes, Ladder[] ladders) {
        this.size = size;
        this.endPosition = startPosition + size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public Snake[] getSnakes() {
        return snakes;
    }

    public Ladder[] getLadders() {
        return ladders;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }
}
