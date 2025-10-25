package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.RacingInputParser;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;

public class Application {
    public static void main(String[] args) {
        RacingInputParser inputParser = new RacingInputParser();
        RacingInputView inputView = new RacingInputView(inputParser);
        RacingOutputView outputView = new RacingOutputView();
        RacingController controller = new RacingController(inputView, outputView);
        controller.run();
    }
}
