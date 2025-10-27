package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.*;

public class Application {
    public static void main(String[] args) {
        RacingInputParser inputParser = new RacingInputParser();
        RacingInputView inputView = new RacingInputViewImpl(inputParser);
        RacingOutputView outputView = new RacingOutputViewImpl();
        RacingService racingService = new RacingService();
        RacingController controller = new RacingController(inputView, outputView, racingService);
        controller.run();
    }
}
