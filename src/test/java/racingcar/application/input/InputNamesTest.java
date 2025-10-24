package racingcar.application.input;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.input.CarNameInput;

public class InputNamesTest {

    CarNameInput carNameInput = new CarNameInput();

    @Test
    @DisplayName("[fail] 공백만 입력 테스트")
    void blankTest() {
        String inputCarNames = "";
        Assertions.assertThatThrownBy(() -> carNameInput.inputNames(inputCarNames))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[fail] 5글자 초과 입력 테스트")
    void lenthTest() {
        String carName = "Leeka99";
        Assertions.assertThatThrownBy(() -> carNameInput.inputNames(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[fail] 숫자 입력 테스트")
    void digitTest() {
        String carName = "8";
        Assertions.assertThatThrownBy(() -> carNameInput.inputNames(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[fail] 숫자 포함 입력 테스트")
    void withDigitTest() {
        String carName = "Leeka,32,pobi";
        Assertions.assertThatThrownBy(() -> carNameInput.inputNames(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[success] (,) 쉼표 기준으로 분리 테스트")
    void seperateTest() {
        String carName = "Leeka,pobi.,*jini";
        Assertions.assertThat(carNameInput.inputNames(carName))
            .isEqualTo(List.of("Leeka", "pobi.", "*jini"));
    }

    @Test
    @DisplayName("[success] 자동차 이름 정상 입력 테스트")
    void inputNamesTest() {
        String carName = "pobi,lisa,jin";
        Assertions.assertThat(carNameInput.inputNames(carName))
            .isEqualTo(List.of("pobi", "lisa", "jin"));
    }

    @Test
    @DisplayName("[success] 자동차 이름 공백 포함 입력 테스트")
    void inputNamesBlankTest() {
        String carName = "Leeka , pobi.,*jini";
        Assertions.assertThat(carNameInput.inputNames(carName))
            .isEqualTo(List.of("Leeka", "pobi.", "*jini"));
    }

    @Test
    @DisplayName("[fail] 동일한 이름 입력 테스트")
    void inputSameNameTest() {
        String carName = "lisa,lisa,Leeka";
        Assertions.assertThatThrownBy(()->carNameInput.inputNames(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
