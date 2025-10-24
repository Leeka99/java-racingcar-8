package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.validation.Validation;

public class CarNameInput {
    private List<String> carNames;

    public void readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputNames(Console.readLine());
    }

    public List<String> inputNames(String inputCarNames) {
        Validation.validBlankNames(inputCarNames);
        seperateNames(checkBlank(inputCarNames));
        validInputNames();
        return carNames;
    }

    private List<String> seperateNames(String inputCarNames) {
        return carNames = java.util.List.of(inputCarNames.split(","));
    }

    private void validInputNames() {
        for (String name : carNames) {
            Validation.validInputName(name);
        }
    }

    private String checkBlank(String input) {
        return input.replace(" ", "");
    }

    public List<String> getCarNames() {
        return carNames;
    }

}
