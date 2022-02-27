package com.game.model;

public class Dice {
    public final int MIN =1;
    public final int MAX =6;
    public int roll() {
        return (int)(Math.random()*(MAX-MIN+1)+MIN);
    }
}
