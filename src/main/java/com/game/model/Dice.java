package com.game.model;

public class Dice {
    private final int MIN =1;
    private final int MAX =6;
    public int roll() {
        return (int)(Math.random()*(MAX-MIN+1)+MIN);
    }
}
