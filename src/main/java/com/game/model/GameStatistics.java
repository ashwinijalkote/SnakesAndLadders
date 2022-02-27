package com.game.model;

import java.util.ArrayList;

public class GameStatistics {
     int countRolls =0;
     int totalAmountOfClimb =0;
     int totalClimbs=0;
     int totalAmountOfSlide =0;
     int totalSlides=0;
     int biggestClimb=0;
     int biggestSlide=0;
     ArrayList<Integer> longestTurn = new ArrayList<>();
    ArrayList<Integer> currentTurn = new ArrayList<>();
    int numUnluckyRolls=0;
    int numLuckyRolls=0;


    public ArrayList<Integer> getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(ArrayList<Integer> currentTurn) {
        this.currentTurn = currentTurn;
    }

    public int getCountRolls() {
        return countRolls;
    }

    public void setCountRolls(int countRolls) {
        this.countRolls = countRolls;
    }

    public int getTotalAmountOfClimb() {
        return totalAmountOfClimb;
    }

    public void setTotalAmountOfClimb(int totalAmountOfClimb) {
        this.totalAmountOfClimb = totalAmountOfClimb;
    }

    public int getTotalClimbs() {
        return totalClimbs;
    }

    public void setTotalClimbs(int totalClimbs) {
        this.totalClimbs = totalClimbs;
    }

    public int getTotalAmountOfSlide() {
        return totalAmountOfSlide;
    }

    public void setTotalAmountOfSlide(int totalAmountOfSlide) {
        this.totalAmountOfSlide = totalAmountOfSlide;
    }

    public int getTotalSlides() {
        return totalSlides;
    }

    public void setTotalSlides(int totalSlides) {
        this.totalSlides = totalSlides;
    }

    public int getBiggestClimb() {
        return biggestClimb;
    }

    public void setBiggestClimb(int biggestClimb) {
        this.biggestClimb = biggestClimb;
    }

    public int getBiggestSlide() {
        return biggestSlide;
    }

    public void setBiggestSlide(int biggestSlide) {
        this.biggestSlide = biggestSlide;
    }

    public ArrayList<Integer> getLongestTurn() {
        return longestTurn;
    }

    public void setLongestTurn(ArrayList<Integer> longestTurn) {
        this.longestTurn = longestTurn;
    }

    public int getNumUnluckyRolls() {
        return numUnluckyRolls;
    }

    public void setNumUnluckyRolls(int numUnluckyRolls) {
        this.numUnluckyRolls = numUnluckyRolls;
    }

    public int getNumLuckyRolls() {
        return numLuckyRolls;
    }

    public void setNumLuckyRolls(int numLuckyRolls) {
        this.numLuckyRolls = numLuckyRolls;
    }

    @Override
    public String toString() {
        return "GameStatistics{" +
                "countRolls=" + countRolls +
                ", amountOfClimbs=" + totalAmountOfClimb +
                ", totalClimbs=" + totalClimbs +
                ", amountOfSlides=" + totalAmountOfSlide +
                ", totalSlides=" + totalSlides +
                ", biggestClimb=" + biggestClimb +
                ", biggestSlide=" + biggestSlide +
                ", currentTurn=" + currentTurn +
                ", longestTurn=" + longestTurn +
                ", numUnluckyRolls=" + numUnluckyRolls +
                ", numLuckyRolls=" + numLuckyRolls +
                '}';
    }
}
