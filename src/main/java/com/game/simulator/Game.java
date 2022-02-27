package com.game.simulator;

import com.game.model.*;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private int gameId;
    private Board board;
    private Player[] players;
    private Dice dice;

    private ArrayDeque<Player> playerTurnQueue;
    private Map<Player, Integer> playerPosition;
    private Map<Integer, Integer> snakesMap;
    private Map<Integer, Integer> ladderMap;


    public Game(int gameId, Board board, Player[] players, Dice dice) {
        this.gameId = gameId;
        this.board = board;
        this.players = players;
        this.dice = dice;
        initGame();
    }

    public int getGameId() {
        return gameId;
    }

    public Board getBoard() {
        return board;
    }

    private void initGame() {
        GameState initialGameState = this.getInitialGameState();
        playerTurnQueue = initialGameState.getPlayerTurnQueue();
        playerPosition = initialGameState.getPlayerPosition();

        snakesMap = new HashMap<>();
        ladderMap = new HashMap<>();

        for (Snake snake : board.getSnakes()) {
            snakesMap.put(snake.getHead(), snake.getTail());
        }
        for (Ladder ladder : board.getLadders()) {
            ladderMap.put(ladder.getStart(), ladder.getEnd());
        }
    }

    public GameState getInitialGameState() {
        ArrayDeque<Player> playerTurnQueueTemp =  new ArrayDeque<>();;
        Map<Player, Integer> playerPositionTemp = new HashMap<>();
        for (Player player : players) {
            playerTurnQueueTemp.offer(player);
            playerPositionTemp.put(player, 0);
        }
        return new GameState(playerTurnQueueTemp, playerPositionTemp, 0);
    }


    public GameState play() {
        Player nextPlayer;
        int newPosition;

        nextPlayer = playerTurnQueue.peek();
        int value = dice.roll();

        if (value != dice.MAX) {
            playerTurnQueue.offer(playerTurnQueue.poll());
        }

        newPosition = playerPosition.get(nextPlayer) + value;
        if (newPosition > board.getEndPosition()) {
            return new GameState(playerTurnQueue, playerPosition, value);
        }
        if (snakesMap.containsKey(newPosition)) {
            newPosition = snakesMap.get(newPosition);
        } else if (ladderMap.containsKey(newPosition)) {
            newPosition = ladderMap.get(newPosition);
        }
        playerPosition.put(nextPlayer, newPosition);
        return new GameState(playerTurnQueue, playerPosition, value);
    }
}
