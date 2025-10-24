package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.Winner;
import racingcar.util.random.RandomNumber;
import racingcar.util.random.RandomNumberGenerator;
import racingcar.view.input.Input;
import racingcar.view.output.Print;

public class RaceController {

    Input input = new Input();
    RandomNumber randomNumber = new RandomNumberGenerator();

    public void run() {
        input.read();

        Race race = new Race(input.getCarNames(), input.getCount(), randomNumber);
        race.start();

        Winner winner = new Winner(input.getCarNames(), race.getGameResult(), race.getMaxNumber());
        winner.calculateFinalResult();

        print(race, winner);
    }

    private void print(Race race, Winner winner) {
        Print.inProcess();
        Print.printCurrentResult(input.getCarNames(), race.getPlayResults());
        Print.winner(winner.getWinnerNumber(), winner.getWinner());
    }
}
