package racingcar.application.gameResult;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Winner;

public class WinnerTest {

    List<String> carNames = List.of("pobi", "lisa", "poo");
    Winner winner;

    @Test
    @DisplayName("[success] 단독 우승자 인원 수 반환 테스트")
    void singleWinnerNumberTest() {
        List<Integer> gameResult = List.of(3, 1, 2);
        int maxNumber = 3;
        winner = new Winner(carNames, gameResult, maxNumber);

        int winnerNumber = winner.calculateFinalResult();

        Assertions.assertThat(winnerNumber)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("[success] 단독 우승자 이름 반환 테스트")
    void singleWinnerNameTest() {
        List<Integer> gameResult = List.of(3, 1, 2);
        int maxNumber = 3;
        winner = new Winner(carNames, gameResult, maxNumber);

        winner.calculateFinalResult();
        List<String> winnerValue = winner.getWinner();

        Assertions.assertThat(winnerValue)
            .isEqualTo(List.of("pobi"));
    }

    @Test
    @DisplayName("[success] 공동 우승자 인원 수 반환 테스트")
    void multiWinnerNumberTest() {
        List<Integer> gameResult = List.of(1, 2, 2);
        int maxNumber = 2;
        winner = new Winner(carNames, gameResult, maxNumber);

        int winnerNumber = winner.calculateFinalResult();

        Assertions.assertThat(winnerNumber)
            .isEqualTo(2);
    }

    @Test
    @DisplayName("[success] 공동 우승자 이름 반환 테스트")
    void multiWinnerNameTest() {
        List<Integer> gameResult = List.of(1, 2, 2);
        int maxNumber = 2;
        winner = new Winner(carNames, gameResult, maxNumber);

        winner.calculateFinalResult();
        List<String> winnerValue = winner.getWinner();

        Assertions.assertThat(winnerValue)
            .isEqualTo(List.of("lisa", "poo"));
    }
}
