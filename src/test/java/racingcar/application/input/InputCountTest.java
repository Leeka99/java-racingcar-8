package racingcar.application.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.input.CountInput;

public class InputCountTest {

    CountInput countInput = new CountInput();

    @Test
    @DisplayName("[fail] 공백만 입력 테스트")
    void blankTest() {
        String count = " ";
        Assertions.assertThatThrownBy(() -> countInput.inputCount(count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[fail] 문자가 포함된 입력 테스트")
    void withStringTest() {
        String count = "횟수는 5";
        Assertions.assertThatThrownBy(() -> countInput.inputCount(count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[fail] 문자 입력 테스트")
    void stringTest() {
        String count = "우아한테크코스!";
        Assertions.assertThatThrownBy(() -> countInput.inputCount(count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[success] 공백 포함 입력 테스트")
    void withBlankTest() {
        String count = "5   ";
        Assertions.assertThat(countInput.inputCount(count))
            .isEqualTo(5);
    }

    @Test
    @DisplayName("[fail] 0 입력 테스트")
    void inputZeroTest() {
        String count = "0";
        Assertions.assertThatThrownBy(() -> countInput.inputCount(count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[fail] 음수 입력 테스트")
    void inputMinusTest() {
        String count = "-7";
        Assertions.assertThatThrownBy(() -> countInput.inputCount(count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[success] 정상 입력 테스트")
    void inputCountTest() {
        String count = "10";
        Assertions.assertThat(countInput.inputCount(count))
            .isEqualTo(10);
    }

    @Test
    @DisplayName("[fail] 소수점이 포함된 숫자 입력 테스트")
    void inputDecimalNumberTest() {
        String count = "3.5";
        Assertions.assertThatThrownBy(() -> countInput.inputCount(count))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[success] 0을 포함한 숫자(ex: 03) 형식의 입력 테스트")
    void inputWithZeroTest(){
        String count = "03";
        Assertions.assertThat(countInput.inputCount(count))
            .isEqualTo(3);
    }
}
