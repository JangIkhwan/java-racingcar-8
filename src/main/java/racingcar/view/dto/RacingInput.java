package racingcar.view.dto;

import racingcar.model.dto.CarNameList;
import racingcar.model.dto.MoveNumber;

public class RacingInput {
    private final CarNameList carNameList;
    private final MoveNumber moveNumber;

    public RacingInput(CarNameList carNameList, MoveNumber moveNumber) {
        this.carNameList = carNameList;
        this.moveNumber = moveNumber;
    }

    public CarNameList getCarNameList() {
        return this.carNameList;
    }

    public MoveNumber getMoveNumber(){
        return this.moveNumber;
    }
}
