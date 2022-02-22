package com.game.app;

import com.game.model.*;
import com.game.processor.StatsProcessor;
import com.game.simulator.Simulator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimulatorTest {

    Snake [] snakes;
    Ladder [] ladders;
    Board board;
    Player player1;
    Player player2;
    Player [] players;
    Dice dice;


    @BeforeEach
    private void setup() {
        snakes = new Snake[] {
                new Snake(40, 3),
                new Snake(27, 5),
                new Snake(43, 18),
                new Snake(54, 31),
                new Snake(66, 45),
                new Snake(76, 58),
                new Snake(89, 53),
                new Snake(99, 41)
        };

        ladders = new Ladder[] {
                new Ladder(4, 25),
                new Ladder(13, 46),
                new Ladder(33, 49),
                new Ladder(42, 63),
                new Ladder(50, 69),
                new Ladder(62, 81),
                new Ladder(74, 92),
        };
        board = new Board(100, snakes,ladders);
        players = new Player[] {new Player("Player1"), new Player("Player2")};
    }

    @Test
    public void testGetStatsForNSimulation(){
       Simulator simulator = new Simulator(2, board, players, dice);
       StatsProcessor.SimulatorOutput simulatorOutput = simulator.run();
       //assert (simulatorOutput.)
    }
}