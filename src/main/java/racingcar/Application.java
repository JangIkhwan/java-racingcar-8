package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.RacingInputParser;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;

public class Application {
    public static void main(String[] args) {
        RacingInputParser inputParser = new RacingInputParser();
        RacingInputView inputView = new RacingInputView(inputParser);
        RacingOutputView outputView = new RacingOutputView();
        RacingService racingService = new RacingService();
        RacingController controller = new RacingController(inputView, outputView, racingService);
        controller.run();
    }
}
