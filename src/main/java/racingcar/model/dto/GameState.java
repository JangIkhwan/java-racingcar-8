package racingcar.model.dto;

import java.util.List;

public class GameState {
    final List<CarState> pairs;

    public GameState(List<CarState> pairs){
        this.pairs = pairs;
    }
}
