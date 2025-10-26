package racingcar.service;

import racingcar.model.RacingGame;
import racingcar.model.dto.GameResult;
import racingcar.view.dto.RacingInput;

public class RacingService {
    private final RacingGame game;

    public RacingService(RacingGame game){
        this.game = game;
    }

    public GameResult race(RacingInput input){
        RacingGame game = new RacingGame(input.getCarNameList(), input.getMoveNumber());
        return game.play();
    }
}
