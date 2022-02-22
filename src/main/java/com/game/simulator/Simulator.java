package com.game.simulator;

import com.game.model.*;
import com.game.processor.StatsProcessor;

import java.util.concurrent.atomic.AtomicBoolean;

public class Simulator {
    int numberOfSimulations;
    Board board;
    Player [] players;
    Dice dice;

    public Simulator(int numberOfSimulations, Board board, Player [] players, Dice dice) {
        this.numberOfSimulations = numberOfSimulations;
        this.board = board;
        this.players = players;
        this.dice = dice;
    }

    private boolean isGameWon(GameState gameState) {
        AtomicBoolean isWon= new AtomicBoolean(false);
        gameState.getPlayerPosition().forEach((player, pos) -> {
            if (pos == 100) {
                isWon.set(true);
            }
        });
        return isWon.get();
    }

    public StatsProcessor.SimulatorOutput run() {
        Game game = new Game(board, players, dice);
        for (int i =0 ; i < numberOfSimulations; i++) {
            StatsProcessor processor = new StatsProcessor();
            GameState previousState;
            GameState currentState = null;
            while(true) {
                previousState = currentState;
                currentState = game.play();
                processor.process(currentState,previousState);
                if (isGameWon(currentState)) break;
            }
        }
        return null;
    }
}
