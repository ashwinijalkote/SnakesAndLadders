package com.game.processor;

import com.game.model.*;

import java.util.*;

public class GameStatsProcessor {
    public static void process(GameStatistics gameStatistics, GameState currentState, GameState prevState, Board board) {
        Player player = prevState.getPlayerTurnQueue().peek();

        int playerPositionBeforeRoll = prevState.getPlayerPosition().get(player);
        int playerPositionAfterRoll = currentState.getPlayerPosition().get(player);
        int temp;
        incrementRollCount(gameStatistics);
        int rollValue = currentState.getRollValue();
        if (isClimb(playerPositionBeforeRoll, playerPositionAfterRoll, rollValue)) {
            incrementClimbs(gameStatistics);
            temp = getAmountOfClimb(playerPositionBeforeRoll, playerPositionAfterRoll, rollValue);
            updateTotalAmountOfClimb(gameStatistics, temp);
            updateBiggestClimb(gameStatistics, temp);
        } else if (isSlide(playerPositionBeforeRoll, playerPositionAfterRoll)) {
            incrementSlides(gameStatistics);
            temp = getAmountOfSlide(playerPositionBeforeRoll, playerPositionAfterRoll, rollValue);
            updateTotalAmountOfSlide(gameStatistics, temp);
            updateBiggestSlide(gameStatistics, temp);
        }
        if (isLuckyRoll(prevState, currentState, board)) {
            incrementLuckyRoll(gameStatistics);
        }
        if (isUnluckyRoll(prevState, currentState)) {
            incrementUnluckyRoll(gameStatistics);
        }
        updateTurn(gameStatistics, prevState, currentState);
    }

    private static void updateTurn(GameStatistics gameStatistics, GameState prevState, GameState currentState) {
        if (isSameTurn(prevState)) {
            gameStatistics.getCurrentTurn().add(currentState.getRollValue());
            gameStatistics.setCurrentTurn(gameStatistics.getCurrentTurn());
        } else {
            updateLongestTurn(gameStatistics);
            gameStatistics.setCurrentTurn(new ArrayList<>());
            gameStatistics.getCurrentTurn().add(currentState.getRollValue());
            gameStatistics.setCurrentTurn(gameStatistics.getCurrentTurn());
        }
    }

    private static void updateLongestTurn(GameStatistics gameStatistics) {
        boolean updateLongestTurn = false;
        if (gameStatistics.getLongestTurn().size() == gameStatistics.getCurrentTurn().size()) {
            int i = gameStatistics.getLongestTurn().size() - 1;
            for (; i >= 0; i--) {
                if (gameStatistics.getLongestTurn().get(i) < gameStatistics.getCurrentTurn().get(i)) {
                    updateLongestTurn = true;
                }
            }
        }
        if (updateLongestTurn || gameStatistics.getLongestTurn().size() < gameStatistics.getCurrentTurn().size()) {
            gameStatistics.setLongestTurn(new ArrayList<>(gameStatistics.getCurrentTurn()));
            gameStatistics.setCurrentTurn(new ArrayList<>());
        }
    }


    private static boolean isSameTurn(GameState prevState) {
        return prevState.getRollValue() == 6;
    }

    private static int getAmountOfSlide(int playerPositionBeforeRoll, int playerPositionAfterRoll, int rollValue) {
        return playerPositionBeforeRoll + rollValue - playerPositionAfterRoll;
    }

    private static boolean isSlide(int playerPositionBeforeRoll, int playerPositionAfterRoll) {
        return playerPositionAfterRoll - playerPositionBeforeRoll < 0;
    }

    private static int getAmountOfClimb(int playerPositionBeforeRoll, int playerPositionAfterRoll, int rollValue) {
        return playerPositionAfterRoll - playerPositionBeforeRoll - rollValue;
    }

    private static boolean isClimb(int playerPositionBeforeRoll, int playerPositionAfterRoll, int rollValue) {
        return playerPositionAfterRoll - playerPositionBeforeRoll > rollValue;
    }


    private static void incrementRollCount(GameStatistics gameStatistics) {
        gameStatistics.setCountRolls(gameStatistics.getCountRolls() + 1);
    }

    private static void incrementClimbs(GameStatistics gameStatistics) {
        gameStatistics.setTotalClimbs(gameStatistics.getTotalClimbs() + 1);
    }

    private static void updateTotalAmountOfClimb(GameStatistics gameStatistics, int amountOfClimb) {
        gameStatistics.setTotalAmountOfClimb(gameStatistics.getTotalAmountOfClimb() + amountOfClimb);
    }

    private static  void incrementSlides(GameStatistics gameStatistics) {
        gameStatistics.setTotalSlides(gameStatistics.getTotalSlides() + 1);
    }

    private static void updateTotalAmountOfSlide(GameStatistics gameStatistics, int amountOfSlide) {
        gameStatistics.setTotalAmountOfSlide(gameStatistics.getTotalAmountOfSlide() + amountOfSlide);
    }

    private static  void updateBiggestClimb(GameStatistics gameStatistics, int amountOfClimb) {
        if (amountOfClimb > gameStatistics.getBiggestClimb()) {
            gameStatistics.setBiggestClimb(amountOfClimb);
        }
    }

    private static void updateBiggestSlide(GameStatistics gameStatistics, int amountOfSlide) {
        if (amountOfSlide > gameStatistics.getBiggestSlide()) {
            gameStatistics.setBiggestSlide(amountOfSlide);
        }

    }

    private static void incrementUnluckyRoll(GameStatistics gameStatistics) {
        gameStatistics.setNumUnluckyRolls(gameStatistics.getNumUnluckyRolls() + 1);
    }

    private static void incrementLuckyRoll(GameStatistics gameStatistics) {
        gameStatistics.setNumLuckyRolls(gameStatistics.getNumLuckyRolls() + 1);
    }

    private static  boolean isUnluckyRoll(GameState prevState, GameState currentState) {
        Player player = prevState.getPlayerTurnQueue().peek();

        int playerPositionBeforeRoll = prevState.getPlayerPosition().get(player);
        int playerPositionAfterRoll = currentState.getPlayerPosition().get(player);

        return isSlide(playerPositionBeforeRoll, playerPositionAfterRoll);
    }

    private static  boolean isLuckyRoll(GameState prevState, GameState currentState, Board board) {
        final int AFTER_POSITION = 94;
        Player player = prevState.getPlayerTurnQueue().peek();

        int playerPositionBeforeRoll = prevState.getPlayerPosition().get(player);
        int playerPositionAfterRoll = currentState.getPlayerPosition().get(player);
        int rollValue = currentState.getRollValue();

        return (isClimb(playerPositionBeforeRoll, playerPositionAfterRoll, rollValue) ||
                (playerPositionAfterRoll == board.getEndPosition() && playerPositionBeforeRoll > AFTER_POSITION && playerPositionAfterRoll - playerPositionBeforeRoll == rollValue) ||
                isMissedSnake(prevState, currentState, board));
    }

    private static boolean isMissedSnake(GameState prevState, GameState currentState, Board board) {
        Player player = prevState.getPlayerTurnQueue().peek();
        Map<Integer, Integer> snakesMap = new TreeMap<>();
        for (Snake snake : board.getSnakes()) {
            snakesMap.put(snake.getHead(), snake.getTail());
        }
        int playerPosition = currentState.getPlayerPosition().get(player);
        return (snakesMap.containsKey(playerPosition - 1) || snakesMap.containsKey(playerPosition - 2) ||
                snakesMap.containsKey(playerPosition + 1) || snakesMap.containsKey(playerPosition + 2));
    }
}
