package racingcar.view.output;

import java.util.List;

public class Print {

    private static final String BAR = "-";

    public static void printCurrentResult(List<String> carNames, List<List<Integer>> playResults) {
        for (List<Integer> result : playResults) {
            for (int index = 0; index < carNames.size(); index++) {
                System.out.println(carNames.get(index) + " : " + BAR.repeat(result.get(index)));
            }
            System.out.println();
        }
    }

    public static void inProcess() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void winner(int winnerNumber, List<String> winner) {
        if (winnerNumber == 1) {
            System.out.println("최종 우승자 : " + winner.get(0));
        }
        if (1 < winnerNumber) {
            System.out.print("최종 우승자 : " + winner.get(0));
            for (int index = 1; index < winner.size(); index++) {
                System.out.print(", " + winner.get(index));
            }
        }
    }

}
