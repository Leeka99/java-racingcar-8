package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    private static List<String> carNames;
    private static int count;

    private static void validBlankNames(String names) {
        if (names.isBlank()) {
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

    private static void seperateNames(String names) {
        carNames = List.of(names.split(","));

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

    public static void inputCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCount = Console.readLine();
        if (inputCount.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (!inputCount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        count = Integer.parseInt(inputCount);
    }

    public static void main(String[] args) {
        input();

        System.out.println("실행 결과");
        List<Integer> gameResult = new ArrayList<>(Collections.nCopies(carNames.size(), 0));
        String bar = "-";
        int maxNumber = Integer.MIN_VALUE;
        while (count != 0) {
            for (int i = 0; i < carNames.size(); i++) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (4 <= randomNumber) {
                    gameResult.set(i, gameResult.get(i) + 1);
                }
            }
            for (int i = 0; i < carNames.size(); i++) {
                System.out.println(carNames.get(i) + " : " + bar.repeat(gameResult.get(i)));
                maxNumber = Math.max(maxNumber, gameResult.get(i));
            }
            System.out.println();
            count--;
        }

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
