package com.game.processor;

import com.game.model.GameState;

public class StatsProcessor {

    int countRolls =0;
    int climbCount = 0;
    int slideCount = 0;


    public void process(GameState current, GameState prev ) {
        countRolls ++;
        if(current.isSlide()){
            slideCount++;
        }
        if(current.isClimb()){
            climbCount++;
        }

    }

    public static class SimulatorOutput {
        /*
        * number of runs
        * winningRollsCount {max, min, average}
        *climbCount {min, max avg}
        * slideCount {min, max, avg}
        * biggestClimb
        * biggestSlide
        * longestTurn
        * unluckyTurns {min, max, average}
        * luckyRolls {min, max, average}
        * */
    }
}
