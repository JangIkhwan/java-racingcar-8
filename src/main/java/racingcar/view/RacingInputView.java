package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.dto.RacingInput;

import java.util.List;

public class RacingInputView {
    private final RacingInputParser inputParser;

    public RacingInputView(RacingInputParser inputParser){
        this.inputParser = inputParser;
    }

    public RacingInput getInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = inputParser.parseCarNames(Console.readLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        int moveNumber = inputParser.parseMoveNumber(Console.readLine());

        return new RacingInput(carNames, moveNumber);
    }
}
