package com.game.simulator;

import com.game.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SimulatorTest {

    Snake [] snakes;
    Ladder [] ladders;
    Board board;
    Player player1;
    Player player2;
    Player [] players;

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
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        players = new Player[] {player1, player2};
    }

    @Test
    public void testGetStatsFor2Simulation(){
       Dice dice = Mockito.mock(Dice.class);
       when(dice.roll()).thenReturn(6,2,5,2,2,5,4,3,6,1,6,2,6,4,5,2,4,6,4,5,3,2,6,2,4,5,4,6,2,4,1,1,6,6,5,6,2,2,2,5,3,2,6,1,2,5,4,2,5,3,4,1,4,4,5,4,4,6,4,3,5,1,6,4,1,3,4,1,3,1,6,6,3,2,4,6,4,4,4,5,3,2,2,5,1,6,1,6,1,2,1,5,2,4,1,6,5,5,4,2,3,6,3,6,1,2,6,1,6,2,1,5,4,2,
        2,5,1,2,5,5,1,4,5,1,3,1,1,3,2,3,2,5,6,1,4,6,3,3,2,4,1,5,2,5,3,6,1,2,3,5,6,2,5,6,4,4,3,1,4,2,3,4,2,1,6,4,3,1,1,5,6,6,1,6,6,2,5,5,2,2,2,2,1,3,3,6,5,1,3,2,3,5,1,3,2,6,4,5,1,3,1,2,5,3,4,5,2);
       Simulator simulator = new Simulator(2, board, players, dice);
       SimulationStatistics simulationStatistics = simulator.run();
       assertEquals(simulationStatistics.getMinRollsNeededToWin(), 93, "Min rolls needed to win does not match");
       assertEquals(simulationStatistics.getMaxRollsNeededToWin(), 114, "Max rolls needed to win does not match");
       assertEquals(simulationStatistics.getAvgRollsNeededToWin(), 103.5, "Avg rolls needed to win does not match");

       assertEquals(simulationStatistics.getMinAmountOfClimbs(), 121, "Min amount of climbs needed to win does not match");
       assertEquals(simulationStatistics.getMaxAmountOfClimbs(), 179, "Max amount of climbs needed to win does not match");
       assertEquals(simulationStatistics.getAvgAmountOfClimbs(), 150.0, "Avg amount of climbs needed to win does not match");

       assertEquals(simulationStatistics.getMinAmountOfSlides(), 318, "Min amount of slides needed to win does not match");
       assertEquals(simulationStatistics.getMaxAmountOfSlides(), 419, "Max amount of slides needed to win does not match");
       assertEquals(simulationStatistics.getAvgAmountOfSlides(), 368.5, "Avg amount of slides needed to win does not match");

        assertEquals(simulationStatistics.getBiggestClimb(), 33, "Biggest climb does not match");
        assertEquals(simulationStatistics.getBiggestSlide(), 58, "Biggest slide does not match");
        assertArrayEquals(simulationStatistics.getLongestTurn().stream().mapToInt(i->i).toArray(), new int[] {6,6,5});

        assertEquals(simulationStatistics.getMinLuckyRolls(), 36, "Min lucky rolls needed to win does not match");
        assertEquals(simulationStatistics.getMaxLuckyRolls(), 36, "Max lucky rolls needed to win does not match");
        assertEquals(simulationStatistics.getAvgLuckyRolls(), 36.0, "Avg lucky rolls needed to win does not match");

        assertEquals(simulationStatistics.getMinUnluckyRolls(), 10, "Min unlucky rolls needed to win does not match");
        assertEquals(simulationStatistics.getMaxUnluckyRolls(), 13, "Max unlucky rolls needed to win does not match");
        assertEquals(simulationStatistics.getAvgUnluckyRolls(), 11.5, "Avg unlucky rolls needed to win does not match");
    }
}