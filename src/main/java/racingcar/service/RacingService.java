package racingcar.service;

import racingcar.model.RacingGame;
import racingcar.model.dto.GameResult;
import racingcar.view.dto.RacingInput;

public class RacingService {
    public GameResult race(RacingInput input){
        RacingGame game = new RacingGame(input.getCarNameList(), input.getMoveNumber());
        return game.play();
    }
}
