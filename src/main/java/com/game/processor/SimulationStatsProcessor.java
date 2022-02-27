package com.game.processor;

import com.game.model.GameStatistics;
import com.game.model.SimulationStatistics;

import java.util.ArrayList;

public class SimulationStatsProcessor {

    public static void process(SimulationStatistics simulationStatistics, GameStatistics gameStatistics, int simulationNo) {
        updateMinRollsNeededToWin(simulationStatistics, gameStatistics);
        updateMaxRollsNeededToWin(simulationStatistics, gameStatistics);
        updateSumRollsNeededToWin(simulationStatistics, gameStatistics);
        updateAvgRollsNeededToWin(simulationStatistics, simulationNo);

        updateMinAmountOfClimbs(simulationStatistics, gameStatistics);
        updateMaxAmountOfClimbs(simulationStatistics, gameStatistics);
        updateSumAmountOfClimbs(simulationStatistics, gameStatistics);
        updateAvgAmountOfClimbs(simulationStatistics, simulationNo);

        updateMinAmountOfSlides(simulationStatistics, gameStatistics);
        updateMaxAmountOfSlides(simulationStatistics, gameStatistics);
        updateSumAmountOfSlides(simulationStatistics, gameStatistics);
        updateAvgAmountOfSlides(simulationStatistics, simulationNo);

        updateBiggestClimb(simulationStatistics, gameStatistics);
        updateBiggestSlide(simulationStatistics, gameStatistics);

        updateLongestTurn(simulationStatistics, gameStatistics);

        updateMinLuckyRolls(simulationStatistics, gameStatistics);
        updateMaxLuckyRolls(simulationStatistics, gameStatistics);
        updateSumLuckyRolls(simulationStatistics, gameStatistics);
        updateAvgLuckyRolls(simulationStatistics, simulationNo);

        updateMinUnluckyRolls(simulationStatistics, gameStatistics);
        updateMaxUnluckyRolls(simulationStatistics, gameStatistics);
        updateSumUnluckyRolls(simulationStatistics, gameStatistics);
        updateAvgUnluckyRolls(simulationStatistics, simulationNo);

    }

    private static void updateMinRollsNeededToWin(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getMinRollsNeededToWin() > gameStatistics.getCountRolls()) {
            simulationStatistics.setMinRollsNeededToWin(gameStatistics.getCountRolls());
        }
    }

    private static void updateMaxRollsNeededToWin(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getMaxRollsNeededToWin() < gameStatistics.getCountRolls()) {
            simulationStatistics.setMaxRollsNeededToWin(gameStatistics.getCountRolls());
        }
    }

    private static void updateSumRollsNeededToWin(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        simulationStatistics.setSumRollsNeededToWin(simulationStatistics.getSumRollsNeededToWin() + gameStatistics.getCountRolls());
    }

    private static void updateAvgRollsNeededToWin(SimulationStatistics simulationStatistics, int simulationNo) {
        simulationStatistics.setAvgRollsNeededToWin((simulationStatistics.getSumRollsNeededToWin() * 1.0f)/simulationNo);
    }

    private static void updateMinAmountOfClimbs(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getMinAmountOfClimbs() > gameStatistics.getTotalAmountOfClimb()) {
            simulationStatistics.setMinAmountOfClimbs(gameStatistics.getTotalAmountOfClimb());
        }
    }

    private static void updateMaxAmountOfClimbs(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getMaxAmountOfClimbs() < gameStatistics.getTotalAmountOfClimb()) {
            simulationStatistics.setMaxAmountOfClimbs(gameStatistics.getTotalAmountOfClimb());
        }
    }

    private static void updateSumAmountOfClimbs(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        simulationStatistics.setSumAmountOfClimbs(simulationStatistics.getSumAmountOfClimbs() + gameStatistics.getTotalAmountOfClimb());
    }

    private static void updateAvgAmountOfClimbs(SimulationStatistics simulationStatistics, int simulationNo) {
        simulationStatistics.setAvgAmountOfClimbs((simulationStatistics.getSumAmountOfClimbs()*1.0f)/simulationNo);
    }

    private static void updateMinAmountOfSlides(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getMinAmountOfSlides() > gameStatistics.getTotalAmountOfSlide()) {
            simulationStatistics.setMinAmountOfSlides(gameStatistics.getTotalAmountOfSlide());
        }
    }


    private static void updateMaxAmountOfSlides(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getMaxAmountOfSlides() < gameStatistics.getTotalAmountOfSlide()) {
            simulationStatistics.setMaxAmountOfSlides(gameStatistics.getTotalAmountOfSlide());
        }
    }

    private static void updateSumAmountOfSlides(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        simulationStatistics.setSumAmountOfSlides(simulationStatistics.getSumAmountOfSlides() + gameStatistics.getTotalAmountOfSlide());
    }

    private static void updateAvgAmountOfSlides(SimulationStatistics simulationStatistics, int simulationNo) {
        simulationStatistics.setAvgAmountOfSlides((simulationStatistics.getSumAmountOfSlides() *1.0f)/simulationNo);
    }

    private static void updateBiggestClimb(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getBiggestClimb() < gameStatistics.getBiggestClimb()) {
            simulationStatistics.setBiggestClimb(gameStatistics.getBiggestClimb());
        }
    }

    private static void updateBiggestSlide(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getBiggestSlide() < gameStatistics.getBiggestSlide()) {
            simulationStatistics.setBiggestSlide(gameStatistics.getBiggestSlide());
        }
    }

    private static void updateLongestTurn(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        boolean updateLongestTurn = false;
        if (gameStatistics.getLongestTurn().size() == simulationStatistics.getLongestTurn().size()) {
            int i = gameStatistics.getLongestTurn().size() - 1;
            for (; i >= 0; i--) {
                if (simulationStatistics.getLongestTurn().get(i) < gameStatistics.getLongestTurn().get(i)) {
                    updateLongestTurn = true;
                }
            }
        }
        if (updateLongestTurn || simulationStatistics.getLongestTurn().size() < gameStatistics.getLongestTurn().size()) {
            simulationStatistics.setLongestTurn(new ArrayList<>(gameStatistics.getLongestTurn()));
        }
    }

    private static void updateMinLuckyRolls(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getMinLuckyRolls() > gameStatistics.getNumLuckyRolls()) {
            simulationStatistics.setMinLuckyRolls(gameStatistics.getNumLuckyRolls());
        }
    }

    private static void updateMaxLuckyRolls(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getMaxLuckyRolls() < gameStatistics.getNumLuckyRolls()) {
            simulationStatistics.setMaxLuckyRolls(gameStatistics.getNumLuckyRolls());
        }
    }

    private static void updateSumLuckyRolls(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        simulationStatistics.setSumLuckyRolls(simulationStatistics.getSumLuckyRolls() + gameStatistics.getNumLuckyRolls());
    }

    private static void updateAvgLuckyRolls(SimulationStatistics simulationStatistics, int simulationNo) {
        simulationStatistics.setAvgLuckyRolls((simulationStatistics.getSumLuckyRolls() *1.0f)/simulationNo);
    }

    private static void updateMinUnluckyRolls(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getMinUnluckyRolls() > gameStatistics.getNumUnluckyRolls()) {
            simulationStatistics.setMinUnluckyRolls(gameStatistics.getNumUnluckyRolls());
        }
    }

    private static void updateMaxUnluckyRolls(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        if (simulationStatistics.getMaxUnluckyRolls() < gameStatistics.getNumUnluckyRolls()) {
            simulationStatistics.setMaxUnluckyRolls(gameStatistics.getNumUnluckyRolls());
        }
    }

    private static void updateSumUnluckyRolls(SimulationStatistics simulationStatistics, GameStatistics gameStatistics) {
        simulationStatistics.setSumUnluckyRolls(simulationStatistics.getSumUnluckyRolls() + gameStatistics.getNumUnluckyRolls());
    }

    private static void updateAvgUnluckyRolls(SimulationStatistics simulationStatistics,  int simulationNo) {
        simulationStatistics.setAvgUnluckyRolls((simulationStatistics.getSumUnluckyRolls() *1.0f)/simulationNo);
    }
}