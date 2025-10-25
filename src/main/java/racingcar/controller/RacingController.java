package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.dto.GameResult;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;
import racingcar.view.dto.RacingInput;

public class RacingController {
    private final RacingInputView inputView;
    private final RacingOutputView outputView;

    public RacingController(RacingInputView inputView, RacingOutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        RacingInput input = inputView.getInput();
        RacingGame game = new RacingGame(input.getCarNames(), input.getMoveNumber());
        GameResult result = game.play();
        outputView.printResult(result);
    }
}
