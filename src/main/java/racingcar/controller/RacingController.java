package racingcar.controller;

import racingcar.model.dto.GameResult;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;
import racingcar.view.dto.RacingInput;

public class RacingController {
    private final RacingInputView inputView;
    private final RacingOutputView outputView;
    private final RacingService racingService;

    public RacingController(RacingInputView inputView, RacingOutputView outputView, RacingService racingService){
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run(){
        RacingInput input = inputView.getInput();
        GameResult result = racingService.race(input);
        outputView.printResult(result);
    }
}
