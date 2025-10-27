package racingcar.service;

import racingcar.model.dto.GameResult;
import racingcar.view.dto.RacingInput;

public interface RacingService {
    GameResult race(RacingInput input);
}
