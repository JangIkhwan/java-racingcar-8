package racingcar.view.dto;

import racingcar.model.dto.CarNameList;

public class RacingInput {
    private final CarNameList carNameList;
    private final int moveNumber;

    public RacingInput(CarNameList carNameList, int moveNumber) {
        this.carNameList = carNameList;
        this.moveNumber = moveNumber;
    }

    public CarNameList getCarNameList() {
        return this.carNameList;
    }

    public int getMoveNumber(){
        return this.moveNumber;
    }
}
