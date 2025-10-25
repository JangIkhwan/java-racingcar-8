package racingcar.view.dto;

import java.util.List;

public class RacingInput {
    private final List<String> carNames;
    private final int moveNumber;

    public RacingInput(List<String> carNames, int moveNumber) {
        this.carNames = carNames;
        this.moveNumber = moveNumber;
    }

    public List<String> getCarNames() {
        return this.carNames;
    }

    public int getMoveNumber(){
        return this.moveNumber;
    }
}
