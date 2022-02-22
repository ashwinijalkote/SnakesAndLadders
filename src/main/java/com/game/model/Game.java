package com.game.model;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Game {

    private Board board;
    private Player[] players;
    private Dice dice;

    private ArrayDeque<Player> playerTurnQueue;
    private Map<Player, Integer> playerPosition;
    private Map<Integer, Integer> snakesMap;
    private Map<Integer, Integer> ladderMap;

    public Game(Board board, Player[] players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        initGame();
    }

    private void initGame() {
        playerPosition = new HashMap<>();
        playerTurnQueue = new ArrayDeque<>();
        playerPosition = new HashMap<>();
        for (Player player : players) {
            playerTurnQueue.offer(player);
            playerPosition.put(player, 0);
        }
        snakesMap = new HashMap<>();
        ladderMap = new HashMap<>();

        for (Snake snake : board.getSnakes()) {
            snakesMap.put(snake.getHead(), snake.getTail());
        }
        for (Ladder ladder : board.getLadders()) {
            ladderMap.put(ladder.getStart(), ladder.getEnd());
        }
    }

    public GameState play() {
        Player nextPlayer;
        int newPosition;
        boolean isClimb = false;
        boolean isSlide = false;

        playerPosition.forEach((player, pos) -> {
            //   System.out.print(player.getName() + " :" + pos +  "\t");
        });

        nextPlayer = playerTurnQueue.peek();
        //playerTurnQueue.forEach(player ->  System.out.println(player.getName()));
        int value = dice.roll();
        // System.out.println(nextPlayer.getName() + " turn " + " dice: "+ value );
        //System.out.print(value+",");

        if (value != 6) {
            playerTurnQueue.offer(playerTurnQueue.poll());
        }

        newPosition = playerPosition.get(nextPlayer) + value;
        if (newPosition > 100) {
            return new GameState(playerTurnQueue, playerPosition, value, false, false);
        } else if (newPosition == 100) {
            System.out.println("winner" + nextPlayer.getName());
        }
        if (snakesMap.containsKey(newPosition)) {
            newPosition = snakesMap.get(newPosition);
            isSlide = true;
        } else if (ladderMap.containsKey(newPosition)) {
            newPosition = ladderMap.get(newPosition);
            isClimb = true;
        }
        playerPosition.put(nextPlayer, newPosition);
        return new GameState(playerTurnQueue, playerPosition, value, isClimb, isSlide);
    }

}
