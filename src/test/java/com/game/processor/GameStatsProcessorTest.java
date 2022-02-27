package com.game.processor;

import com.game.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GameStatsProcessorTest {

    Snake [] snakes;
    Ladder [] ladders;
    Board board;
    Player player1;
    Player player2;

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
    }

    @Test
    public void testProcessGameStats() {
        ArrayDeque<Player> queue1 = getPlayerTurnQueue(player1, player2);
        Map<Player, Integer> prevPlayerPosition  = getPlayerPosition(player1, 0, player2, 0);
        ArrayDeque<Player> queue2 = getPlayerTurnQueue(player1, player2);
        Map<Player, Integer> currentPlayerPosition  = getPlayerPosition(player1, 0, player2, 6);

        GameState prevState = new GameState(queue1, prevPlayerPosition, 0 );
        GameState currentState = new GameState(queue2, currentPlayerPosition, 6 );
        GameStatistics gameStatistics = new GameStatistics();
        GameStatsProcessor.process(gameStatistics, currentState, prevState, board);
        assertEquals(gameStatistics.getCountRolls(), 1, "Count rolls does not match ");
        assertArrayEquals(gameStatistics.getCurrentTurn().stream().mapToInt(i->i).toArray(), new int[]{6}, "Current turn does not match");

    }

    private ArrayDeque<Player> getPlayerTurnQueue(Player player1, Player player2) {
        ArrayDeque<Player>  queue = new ArrayDeque<>();
        queue.add(player1);
        queue.add(player2);
        return queue;
    }

    private Map<Player, Integer> getPlayerPosition(Player player1, int pos1, Player player2, int pos2) {
        Map<Player, Integer> playerPosition = new HashMap<>();
        playerPosition.put(player1, pos1);
        playerPosition.put(player2, pos2);
        return playerPosition;
    }
}