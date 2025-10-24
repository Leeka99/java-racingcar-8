package racingcar.application.raceLogic;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;
import racingcar.util.random.RandomNumber;
import racingcar.util.random.RandomNumberGenerator;

public class RaceLogicTest {

    List<String> carNames = List.of("Leeka", "pobi", "poo");
    Race raceLogic;

    @Test
    @DisplayName("[success] 랜덤 값 4 이상 테스트")
    void randomOverFourTest() {
        int count = 5;
        RandomNumber randomNumber = () -> 7;
        List<Integer> gameResult = new ArrayList<>();
        gameResult.add(1);
        gameResult.add(2);
        gameResult.add(3);
        raceLogic = new Race(carNames, count, gameResult, randomNumber);

        List<Integer> result = raceLogic.calculateDistance();

        Assertions.assertThat(result)
            .isEqualTo(List.of(2, 3, 4));
    }

    @Test
    @DisplayName("[success] 랜덤 값 4 미만 테스트")
    void randomUnderFourTest() {
        int count = 3;
        RandomNumber randomNumber = () -> 1;
        List<Integer> gameResult = new ArrayList<>();
        gameResult.add(2);
        gameResult.add(2);
        gameResult.add(2);
        raceLogic = new Race(carNames, count, gameResult, randomNumber);

        List<Integer> result = raceLogic.calculateDistance();

        Assertions.assertThat(result)
            .isEqualTo(List.of(2, 2, 2));
    }

    @Test
    @DisplayName("[success] count 값 테스트")
    void countValueTest() {
        int count = 10;
        List<Integer> gameResult = new ArrayList<>();
        RandomNumber randomNumber = new RandomNumberGenerator();
        gameResult.add(6);
        gameResult.add(7);
        gameResult.add(8);
        raceLogic = new Race(carNames, count, gameResult, randomNumber);

        raceLogic.calculateDistance();
        int result = raceLogic.getCountValue();

        Assertions.assertThat(result)
            .isEqualTo(9);
    }

    @Test
    @DisplayName("[success] maxNumber 값 테스트")
    void maxNumberValueTest() {

        int count = 3;
        List<Integer> gameResult = new ArrayList<>();
        RandomNumber randomNumber = () -> 9;
        gameResult.add(3);
        gameResult.add(5);
        gameResult.add(7);
        raceLogic = new Race(carNames, count, gameResult, randomNumber);

        raceLogic.calculateDistance();
        int maxNumber = raceLogic.getMaxNumber();

        Assertions.assertThat(maxNumber)
            .isEqualTo(8);
    }

    @Test
    @DisplayName("[success] playResult 값 테스트")
    void playResultValueTest() {

        int count = 3;
        List<Integer> gameResult = new ArrayList<>();
        RandomNumber randomNumber = () -> 9;
        gameResult.add(0);
        gameResult.add(0);
        gameResult.add(0);
        raceLogic = new Race(carNames, count, gameResult, randomNumber);

        raceLogic.start();
        List<List<Integer>> playResults = raceLogic.getPlayResults();

        Assertions.assertThat(playResults)
            .isEqualTo(List.of(List.of(1, 1, 1), List.of(2, 2, 2), List.of(3, 3, 3)));
    }
}
