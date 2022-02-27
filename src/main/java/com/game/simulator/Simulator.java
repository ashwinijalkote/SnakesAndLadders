package com.game.simulator;

import com.game.model.*;
import com.game.processor.GameStatsProcessor;
import com.game.processor.SimulationStatsProcessor;

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

    public SimulationStatistics run() {
        SimulationStatistics simulationStatistics = new SimulationStatistics();
        for (int i =0 ; i < numberOfSimulations; i++) {
            Game game = new Game(i+1, board, players, dice);
            GameStatistics gameStatistics = new GameStatistics();
            GameState previousState = game.getInitialGameState();

            GameState currentState = null;
//            System.out.println(previousState);

            while(true) {
                currentState = game.play();
                GameStatsProcessor.process(gameStatistics, currentState, previousState, game.getBoard());
//                System.out.print(currentState);
 //               System.out.println(gameStatistics);

                if (isGameWon(currentState)) {
                    System.out.println("winner : " + previousState.getPlayerTurnQueue().peek().getName());
                    break;
                }
                previousState = currentState;
            }
            System.out.println(gameStatistics);
            SimulationStatsProcessor.process(simulationStatistics, gameStatistics, i+1);
            System.out.println(simulationStatistics);

        }
        return simulationStatistics;
    }
}
