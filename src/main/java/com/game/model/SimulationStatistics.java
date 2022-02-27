package com.game.model;

import java.util.ArrayList;

public class SimulationStatistics {
    int minRollsNeededToWin = Integer.MAX_VALUE;
    int maxRollsNeededToWin =0;
    int sumRollsNeededToWin =0;
    float avgRollsNeededToWin =0;
    int minAmountOfClimbs = Integer.MAX_VALUE;
    int maxAmountOfClimbs = 0;
    int sumAmountOfClimbs = 0;
    float avgAmountOfClimbs = 0;
    int minAmountOfSlides = Integer.MAX_VALUE;
    int maxAmountOfSlides = 0;
    int sumAmountOfSlides = 0;
    float avgAmountOfSlides = 0;
    int biggestClimb =0;
    int biggestSlide = 0;
    ArrayList<Integer> longestTurn = new ArrayList<>();
    int minUnluckyRolls = Integer.MAX_VALUE;
    int maxUnluckyRolls =0;
    int sumUnluckyRolls =0;
    float avgUnluckyRolls =0;
    int minLuckyRolls = Integer.MAX_VALUE;
    int maxLuckyRolls =0;
    int sumLuckyRolls =0;
    float avgLuckyRolls =0;

    public int getMinRollsNeededToWin() {
        return minRollsNeededToWin;
    }

    public void setMinRollsNeededToWin(int minRollsNeededToWin) {
        this.minRollsNeededToWin = minRollsNeededToWin;
    }

    public int getMaxRollsNeededToWin() {
        return maxRollsNeededToWin;
    }

    public void setMaxRollsNeededToWin(int maxRollsNeededToWin) {
        this.maxRollsNeededToWin = maxRollsNeededToWin;
    }

    public float getAvgRollsNeededToWin() {
        return avgRollsNeededToWin;
    }

    public void setAvgRollsNeededToWin(float avgRollsNeededToWin) {
        this.avgRollsNeededToWin = avgRollsNeededToWin;
    }

    public int getMinAmountOfClimbs() {
        return minAmountOfClimbs;
    }

    public void setMinAmountOfClimbs(int minAmountOfClimbs) {
        this.minAmountOfClimbs = minAmountOfClimbs;
    }

    public int getMaxAmountOfClimbs() {
        return maxAmountOfClimbs;
    }

    public void setMaxAmountOfClimbs(int maxAmountOfClimbs) {
        this.maxAmountOfClimbs = maxAmountOfClimbs;
    }

    public float getAvgAmountOfClimbs() {
        return avgAmountOfClimbs;
    }

    public void setAvgAmountOfClimbs(float avgAmountOfClimbs) {
        this.avgAmountOfClimbs = avgAmountOfClimbs;
    }

    public int getMinAmountOfSlides() {
        return minAmountOfSlides;
    }

    public void setMinAmountOfSlides(int minAmountOfSlides) {
        this.minAmountOfSlides = minAmountOfSlides;
    }

    public int getMaxAmountOfSlides() {
        return maxAmountOfSlides;
    }

    public void setMaxAmountOfSlides(int maxAmountOfSlides) {
        this.maxAmountOfSlides = maxAmountOfSlides;
    }

    public float getAvgAmountOfSlides() {
        return avgAmountOfSlides;
    }

    public void setAvgAmountOfSlides(float avgAmountOfSlides) {
        this.avgAmountOfSlides = avgAmountOfSlides;
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

    public int getMinUnluckyRolls() {
        return minUnluckyRolls;
    }

    public void setMinUnluckyRolls(int minUnluckyRolls) {
        this.minUnluckyRolls = minUnluckyRolls;
    }

    public int getMaxUnluckyRolls() {
        return maxUnluckyRolls;
    }

    public void setMaxUnluckyRolls(int maxUnluckyRolls) {
        this.maxUnluckyRolls = maxUnluckyRolls;
    }

    public float getAvgUnluckyRolls() {
        return avgUnluckyRolls;
    }

    public void setAvgUnluckyRolls(float avgUnluckyRolls) {
        this.avgUnluckyRolls = avgUnluckyRolls;
    }

    public int getMinLuckyRolls() {
        return minLuckyRolls;
    }

    public void setMinLuckyRolls(int minLuckyRolls) {
        this.minLuckyRolls = minLuckyRolls;
    }

    public int getMaxLuckyRolls() {
        return maxLuckyRolls;
    }

    public void setMaxLuckyRolls(int maxLuckyRolls) {
        this.maxLuckyRolls = maxLuckyRolls;
    }

    public float getAvgLuckyRolls() {
        return avgLuckyRolls;
    }

    public void setAvgLuckyRolls(float avgLuckyRolls) {
        this.avgLuckyRolls = avgLuckyRolls;
    }

    public int getSumRollsNeededToWin() {
        return sumRollsNeededToWin;
    }

    public void setSumRollsNeededToWin(int sumRollsNeededToWin) {
        this.sumRollsNeededToWin = sumRollsNeededToWin;
    }

    public int getSumAmountOfClimbs() {
        return sumAmountOfClimbs;
    }

    public void setSumAmountOfClimbs(int sumAmountOfClimbs) {
        this.sumAmountOfClimbs = sumAmountOfClimbs;
    }

    public int getSumAmountOfSlides() {
        return sumAmountOfSlides;
    }

    public void setSumAmountOfSlides(int sumAmountOfSlides) {
        this.sumAmountOfSlides = sumAmountOfSlides;
    }

    public int getSumUnluckyRolls() {
        return sumUnluckyRolls;
    }

    public void setSumUnluckyRolls(int sumUnluckyRolls) {
        this.sumUnluckyRolls = sumUnluckyRolls;
    }

    public int getSumLuckyRolls() {
        return sumLuckyRolls;
    }

    public void setSumLuckyRolls(int sumLuckyRolls) {
        this.sumLuckyRolls = sumLuckyRolls;
    }

    @Override
    public String toString() {
        return "SimulationStatistics{" +
                "minRollsNeededToWin=" + minRollsNeededToWin +
                ", maxRollsNeededToWin=" + maxRollsNeededToWin +
                ", avgRollsNeededToWin=" + avgRollsNeededToWin +
                ", minAmountOfClimbs=" + minAmountOfClimbs +
                ", maxAmountOfClimbs=" + maxAmountOfClimbs +
                ", avgAmountOfClimbs=" + avgAmountOfClimbs +
                ", minAmountOfSlides=" + minAmountOfSlides +
                ", maxAmountOfSlides=" + maxAmountOfSlides +
                ", avgAmountOfSlides=" + avgAmountOfSlides +
                ", biggestClimb=" + biggestClimb +
                ", biggestSlide=" + biggestSlide +
                ", longestTurn=" + longestTurn +
                ", minUnluckyRolls=" + minUnluckyRolls +
                ", maxUnluckyRolls=" + maxUnluckyRolls +
                ", avgUnluckyRolls=" + avgUnluckyRolls +
                ", minLuckyRolls=" + minLuckyRolls +
                ", maxLuckyRolls=" + maxLuckyRolls +
                ", avgLuckyRolls=" + avgLuckyRolls +
                '}';
    }
}
