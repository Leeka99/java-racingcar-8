package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.util.RemoveSpace;
import racingcar.util.validation.Validation;

public class CarNameInput {

    private List<String> carNames;
    private Map<String, Integer> countName = new HashMap<>();

    public void readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputNames(Console.readLine());
    }

    public List<String> inputNames(String inputCarNames) {
        Validation.validBlankNames(inputCarNames);
        seperateNames(RemoveSpace.remove(inputCarNames));
        validInputNames();
        return carNames;
    }

    private List<String> seperateNames(String inputCarNames) {
        return carNames = java.util.List.of(inputCarNames.split(","));
    }

    private void validInputNames() {
        Validation.validInputNameOnlyOne(carNames.size());
        for (String name : carNames) {
            int value = countName.getOrDefault(name, 0) + 1;
            countName.put(name, value);
            Validation.validInputName(name, value);
        }
    }


    public List<String> getCarNames() {
        return carNames;
    }

}
