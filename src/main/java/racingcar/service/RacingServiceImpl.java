package racingcar.service;

import racingcar.model.RacingGame;
import racingcar.model.dto.GameResult;
import racingcar.model.strategy.CarMovingStrategyImpl;
import racingcar.view.dto.RacingInput;

public class RacingServiceImpl implements RacingService{
    public GameResult race(RacingInput input){
        CarMovingStrategyImpl carMovingStrategy = new CarMovingStrategyImpl();
        RacingGame game = new RacingGame(input.getCarNameList(), input.getMoveNumber(), carMovingStrategy);
        return game.play();
    }
}
