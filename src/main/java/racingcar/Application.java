package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    private static List<String> carNames;
    private static int count;
    private static List<Integer> gameResult;
    private static int maxNumber = Integer.MIN_VALUE;
    private static final String BAR = "-";

    private static void validBlankNames(String inputCarNames) {
        if (inputCarNames.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validInputName(String name) {
        if (5 < name.length()) {
            throw new IllegalArgumentException();
        }
        if (name.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validInputNames() {
        for (String name : carNames) {
            validInputName(name);
        }
    }

    private static void seperateNames(String inputCarNames) {
        carNames = List.of(inputCarNames.split(","));

    }

    private static void input() {
        inputNames();
        inputCount();
    }

    private static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static void inputNames() {
        String inputCarNames = readCarNames();
        validBlankNames(inputCarNames);
        seperateNames(inputCarNames);
        validInputNames();
    }

    private static String readCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    private static void validCount(String inputCount) {
        if (inputCount.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (!inputCount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    private static void parseCount(String inputCount) {
        count = Integer.parseInt(inputCount);
    }

    public static void inputCount() {
        String inputCount = readCount();
        validCount(inputCount);
        parseCount(inputCount);
    }

    private static void updateCarPosition(int index) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (4 <= randomNumber) {
            gameResult.set(index, gameResult.get(index) + 1);
        }
    }

    private static void moveCar() {
        for (int index = 0; index < carNames.size(); index++) {
            updateCarPosition(index);
        }
    }

    private static void saveMaxResult() {
        for (int index = 0; index < carNames.size(); index++) {
            maxNumber = Math.max(maxNumber, gameResult.get(index));
        }
    }

    private static void updateCount() {
        count--;
    }

    private static void printCurrentResult() {
        for (int index = 0; index < carNames.size(); index++) {
            System.out.println(carNames.get(index) + " : " + BAR.repeat(gameResult.get(index)));
        }
        System.out.println();
    }

    private static void calculateCurrentResult() {
        gameResult = new ArrayList<>(Collections.nCopies(carNames.size(), 0));
        while (count != 0) {
            moveCar();
            printCurrentResult();
            saveMaxResult();
            updateCount();
        }
    }

    public static void race() {
        System.out.println("실행 결과");
        calculateCurrentResult();
    }

    public static void main(String[] args) {
        input();
        race();

        if (Collections.frequency(gameResult, maxNumber) == 1) {
            System.out.println("최종 우승자 : " + carNames.get(gameResult.indexOf(maxNumber)));
            return;
        }

        System.out.print("최종 우승자 : " + carNames.get(gameResult.indexOf(maxNumber)));
        for (int i = gameResult.indexOf(maxNumber) + 1; i < carNames.size(); i++) {
            if (gameResult.get(i) == maxNumber) {
                System.out.print(", " + carNames.get(i));
            }
        }
    }
}
