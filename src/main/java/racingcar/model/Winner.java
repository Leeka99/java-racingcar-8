package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    private List<String> winner = new ArrayList<>();
    private List<String> carNames;
    private List<Integer> gameResult;
    private int maxNumber;
    private int winnerNumber;

    public Winner(List<String> carNames, List<Integer> gameResult, int maxNumber) {
        this.carNames = carNames;
        this.gameResult = gameResult;
        this.maxNumber = maxNumber;
    }

    public int calculateFinalResult() {
        winnerNumber = Collections.frequency(gameResult, maxNumber);
        if (winnerNumber == 1) {
            singleWinner();
        }
        if (1 < winnerNumber) {
            multiWinners();
        }
        return winnerNumber;
    }

    private List<String> singleWinner() {
        winner.add(carNames.get(gameResult.indexOf(maxNumber)));
        return winner;
    }

    private void multiWinners() {
        for (int index = gameResult.indexOf(maxNumber); index < carNames.size(); index++) {
            saveMultiWinners(index);
        }
    }

    private void saveMultiWinners(int index) {
        if (gameResult.get(index) == maxNumber) {
            winner.add(carNames.get(index));
        }
    }

    public List<String> getWinner() {
        return winner;
    }

    public int getWinnerNumber() {
        return winnerNumber;
    }
}
