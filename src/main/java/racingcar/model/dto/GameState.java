package racingcar.model.dto;

import java.util.List;

public class GameState {
    final List<CarState> carStates;

    public GameState(List<CarState> carStates){
        this.carStates = carStates;
    }

    public List<CarState> getCarStates() {
        return carStates;
    }
}
