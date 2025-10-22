package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();

        List<String> carNames = List.of(inputCarNames.split(","));

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCount = Console.readLine();
        int count = Integer.parseInt(inputCount);

        System.out.println("실행 결과");
        List<Integer> gameResult = new ArrayList<>(Collections.nCopies(carNames.size(), 0));
        while (count != 0) {
            for (int i = 0; i < carNames.size(); i++) {
                int randomNumber = Randoms.pickNumberInRange(0,9);
                if (4 <= randomNumber) {
                    gameResult.set(i, gameResult.get(i)+1);
                }
            }
            count--;
        }
    }
}
