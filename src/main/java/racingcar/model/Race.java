package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.random.RandomNumber;

public class Race {
    private List<String> carNames;
    private int count;
    private List<Integer> gameResult;
    private int maxNumber = Integer.MIN_VALUE;
    private List<List<Integer>> playResults = new ArrayList<>();
    private RandomNumber randomNumber;

    public Race(List<String> carNames, int count, RandomNumber randomNumber) {
        this.carNames = carNames;
        gameResult = new ArrayList<>(Collections.nCopies(carNames.size(), 0));
        this.count = count;
        this.randomNumber = randomNumber;
    }

    public Race(List<String> carNames, int count, List<Integer> gameResult, RandomNumber randomNumber) {
        this.carNames = carNames;
        this.gameResult = gameResult;
        this.count = count;
        this.randomNumber = randomNumber;
    }

    public void start() {
        while (count != 0) {
            calculateDistance();
        }
    }

    private int random() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Integer> calculateDistance() {
        moveCar();
        saveResult();
        saveMaxResult();
        updateCount();
        return gameResult;
    }

    private void updateCarPosition(int index, int randomNumber) {
        if (4 <= randomNumber) {
            gameResult.set(index, gameResult.get(index) + 1);
        }
    }

    private void moveCar() {
        for (int index = 0; index < carNames.size(); index++) {
            updateCarPosition(index, randomNumber.generate());
        }
    }

    private void saveMaxResult() {
        for (int index = 0; index < carNames.size(); index++) {
            maxNumber = Math.max(maxNumber, gameResult.get(index));
        }
    }

    private void updateCount() {
        count--;
    }

    private void saveResult() {
        playResults.add(new ArrayList<>(gameResult));
    }

    public List<Integer> getGameResult() {
        return gameResult;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public List<List<Integer>> getPlayResults() {
        return playResults;
    }

    public int getCountValue() {
        return count;
    }
}
