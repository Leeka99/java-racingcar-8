package racingcar.application.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class inputCountTest {
    Application raceGame = new Application();

    @Test
    @DisplayName("[fail] 공백 입력 테스트")
    void blankTest() {
        String count = " ";
        Assertions.assertThatThrownBy(()->raceGame.inputCount(count)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[fail] 문자 입력 테스트")
    void stringTest() {
        String count = "횟수는 5";
        Assertions.assertThatThrownBy(()->raceGame.inputCount(count)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[success] 공백 포함 입력 테스트")
    void withBlankTest() {
        String count = "5   ";
        Assertions.assertThat(raceGame.inputCount(count)).isEqualTo(5);
    }

    @Test
    @DisplayName("[fail] 0 입력 테스트")
    void inputZero() {
        String count = "0";
        Assertions.assertThatThrownBy(()->raceGame.inputCount(count)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[fail] 음수 입력 테스트")
    void inputMinus() {
        String count = "-7";
        Assertions.assertThatThrownBy(()->raceGame.inputCount(count)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[success] 정상 입력 테스트")
    void inputCountTest() {
        String count = "10";
        Assertions.assertThat(raceGame.inputCount(count)).isEqualTo(10);
    }

}
