package racingcar.application.gameResult;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class gameResultTest {

    List<String> carNames = List.of("pobi","lisa","poo");
    Application raceGame;

    @Test
    @DisplayName("[success] 단독 우승자 테스트")
    void singleWinner() {
        List<Integer> gameResult = List.of(3,1,2);
        int maxNumber = 3;
        raceGame = new Application(carNames, gameResult, maxNumber);

        int winnerNumber = raceGame.calculateFinalResult();

        Assertions.assertThat(winnerNumber).isEqualTo(1);
        Assertions.assertThat(raceGame.getWinner()).isEqualTo(List.of("pobi"));
    }

    @Test
    @DisplayName("[success] 공동 우승자 테스트")
    void multiWinner() {
        List<Integer> gameResult = List.of(1,2,2);
        int maxNumber = 2;
        raceGame = new Application(carNames, gameResult, maxNumber);

        int winnerNumber = raceGame.calculateFinalResult();

        Assertions.assertThat(winnerNumber).isEqualTo(2);
        Assertions.assertThat(raceGame.getWinner()).isEqualTo(List.of("lisa","poo"));
    }

}
