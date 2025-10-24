package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.validation.Validation;

public class CountInput {
    private int count;

    public void readCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        inputCount(Console.readLine());
    }

    public int inputCount(String inputCount) {
        String check = checkBlank(inputCount);
        String valid = Validation.validCount(check);
        return parseCount(valid);
    }

    private int parseCount(String inputCount) {
        return count = Integer.parseInt(inputCount);
    }

    private String checkBlank(String input) {
        return input.replace(" ", "");
    }

    public int getCount() {
        return count;
    }
}
