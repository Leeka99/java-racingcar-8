package racingcar.application.raceLogic;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class raceLogicTest {

    List<String> carNames = List.of("Leeka", "pobi", "poo");
    Application raceGame;

    @Test
    @DisplayName("[success] 랜덤 값 4 이상 테스트")
    void randomOverFourTest() {
        int count = 5;
        List<Integer> gameResult = new ArrayList<>();
        gameResult.add(1);
        gameResult.add(2);
        gameResult.add(3);
        raceGame = new Application(carNames, count, gameResult);

        List<Integer> result = raceGame.calculateCurrentResult(7);

        Assertions.assertThat(result).isEqualTo(List.of(2, 3, 4));
    }

    @Test
    @DisplayName("[success] 랜덤 값 4 미만 테스트")
    void randomUnderFourTest() {
        int count = 3;
        List<Integer> gameResult = new ArrayList<>();
        gameResult.add(2);
        gameResult.add(2);
        gameResult.add(2);
        raceGame = new Application(carNames, count, gameResult);

        List<Integer> result = raceGame.calculateCurrentResult(3);

        Assertions.assertThat(result).isEqualTo(List.of(2, 2, 2));
    }

    @Test
    @DisplayName("[success] count 값 테스트")
    void countValueTest() {
        int count = 10;
        List<Integer> gameResult = new ArrayList<>();
        gameResult.add(6);
        gameResult.add(7);
        gameResult.add(8);
        raceGame = new Application(carNames, count, gameResult);

        raceGame.calculateCurrentResult(1);
        int result = raceGame.getCountValue();

        Assertions.assertThat(result).isEqualTo(9);
    }
}
