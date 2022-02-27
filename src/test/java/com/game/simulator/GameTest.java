package com.game.simulator;

import com.game.model.*;
import com.game.simulator.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class GameTest {

    Snake[] snakes;
    Ladder[] ladders;
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
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        players = new Player[] {player1, player2};
        dice = Mockito.mock(Dice.class);
    }

    @Test
    public void testPlayerPositionAndQueueAfterOneDiceRoll() {
        Game game = new Game(1, board, players, dice);
        Mockito.when(dice.roll()).thenReturn(3);
        GameState gameState = game.play();
        Assertions.assertEquals(gameState.getPlayerPosition().get(player1), 3);
        Assertions.assertEquals(gameState.getPlayerPosition().get(player2), 0);
        Assertions.assertEquals(gameState.getPlayerTurnQueue().peek(), player2);
    }

    @Test
    public void testPlayerPositionAndQueueAfterTwoDiceRoll() {
        Mockito.when(dice.roll()).thenReturn(3,2);
        Game game = new Game(1, board, players, dice);
        game.play();
        GameState gameState = game.play();
        Assertions.assertEquals(gameState.getPlayerPosition().get(player1), 3);
        Assertions.assertEquals(gameState.getPlayerPosition().get(player2), 2);
        Assertions.assertEquals(gameState.getPlayerTurnQueue().peek(), player1);
    }

    @Test
    public void testPlayerPositionAndQueueForPlayerWhenDiceRollsSix() {
        Mockito.when(dice.roll()).thenReturn(3,2,6);
        Game game = new Game(1, board, players, dice);
        game.play();
        game.play();
        GameState gameState = game.play();
        Assertions.assertEquals(gameState.getPlayerPosition().get(player1), 9);
        Assertions.assertEquals(gameState.getPlayerPosition().get(player2), 2);
        Assertions.assertEquals(gameState.getPlayerTurnQueue().peek(), player1);
    }
}