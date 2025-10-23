package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    private List<String> carNames;
    private int count;
    private List<Integer> gameResult;
    private List<String> winner = new ArrayList<>();
    private int maxNumber = Integer.MIN_VALUE;
    private static final String BAR = "-";

    public static void main(String[] args) {
        Application raceGame = new Application();
        raceGame.input();
        raceGame.race();
        raceGame.printResult();
    }

    private void validBlankNames(String inputCarNames) {
        if (inputCarNames.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validInputName(String name) {
        if (5 < name.length()) {
            throw new IllegalArgumentException();
        }
        if (name.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    private void validInputNames() {
        for (String name : carNames) {
            validInputName(name);
        }
    }

    private List<String> seperateNames(String inputCarNames) {
        return carNames = List.of(inputCarNames.split(","));
    }

    private void input() {
        inputNames(readCarNames());
        inputCount(readCount());
    }

    private String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private String checkBlank(String input) {
        return input.replace(" ", "");
    }

    public List<String> inputNames(String inputCarNames) {
        validBlankNames(inputCarNames);
        seperateNames(checkBlank(inputCarNames));
        validInputNames();
        return carNames;
    }

    private String readCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    private void validCount(String inputCount) {
        if (inputCount.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (!inputCount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(inputCount) < 1) {
            throw new IllegalArgumentException();
        }
    }

    private void parseCount(String inputCount) {
        count = Integer.parseInt(inputCount);
    }

    public void inputCount(String inputCount) {
        validCount(inputCount);
        parseCount(checkBlank(inputCount));
    }

    private void updateCarPosition(int index) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (4 <= randomNumber) {
            gameResult.set(index, gameResult.get(index) + 1);
        }
    }

    private void moveCar() {
        for (int index = 0; index < carNames.size(); index++) {
            updateCarPosition(index);
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

    private void printCurrentResult() {
        for (int index = 0; index < carNames.size(); index++) {
            System.out.println(carNames.get(index) + " : " + BAR.repeat(gameResult.get(index)));
        }
        System.out.println();
    }

    public List<Integer> calculateCurrentResult() {
        gameResult = new ArrayList<>(Collections.nCopies(carNames.size(), 0));
        while (count != 0) {
            moveCar();
            printCurrentResult();
            saveMaxResult();
            updateCount();
        }
        return gameResult;
    }

    private void race() {
        System.out.println();
        System.out.println("실행 결과");
        calculateCurrentResult();
    }

    private List<String> singleWinner(int winnerNumber) {
        winner.add(carNames.get(gameResult.indexOf(maxNumber)));
        return winner;
    }

    private void multiWinners(int winnerNumber) {
        for (int index = gameResult.indexOf(maxNumber); index < carNames.size(); index++) {
            saveMultiWinners(index);
        }
    }

    private void saveMultiWinners(int index) {
        if (gameResult.get(index) == maxNumber) {
            winner.add(carNames.get(index));
        }
    }

    private void printWinner(int winnerNumber) {
        if (winnerNumber == 1) {
            System.out.println("최종 우승자 : " + winner.get(0));
        }
        if (1 < winnerNumber) {
            System.out.print("최종 우승자 : " + winner.get(0));
            for (int index = 1; index < winner.size(); index++) {
                System.out.print(", " + winner.get(index));
            }
        }
    }

    public int calculateFinalResult() {
        int winnerNumber = Collections.frequency(gameResult, maxNumber);
        if (winnerNumber == 1) singleWinner(winnerNumber);
        if (1 < winnerNumber) multiWinners(winnerNumber);
        return winnerNumber;
    }

    public void printResult() {
        printWinner(calculateFinalResult());
    }
}