package racingcar.view.input;

import java.util.List;

public class Input {

    private CarNameInput carNameInput = new CarNameInput();
    private CountInput countInput = new CountInput();

    public void read() {
        carNameInput.readCarNames();
        countInput.readCount();
    }

    public List<String> getCarNames() {
        return carNameInput.getCarNames();
    }

    public int getCount() {
        return countInput.getCount();
    }
}
