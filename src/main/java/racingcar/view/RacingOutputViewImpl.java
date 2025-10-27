package racingcar.view;

import racingcar.model.dto.CarState;
import racingcar.model.dto.GameResult;
import racingcar.model.dto.GameState;

import java.util.List;

public class RacingOutputViewImpl implements RacingOutputView {
    public void printResult(GameResult result) {
        printGameStates(result.getGameStates());
        printWinner(result.getWinnerNames());
    }

    private void printGameStates(List<GameState> gameStates) {
        System.out.println("실행 결과");
        for(GameState state : gameStates){
            printGameState(state);
        }
    }

    private void printGameState(GameState state) {
        for(CarState carState : state.getCarStates()){
            System.out.println(carState.getName() + " : " + getDistanceBar(carState.getDistance()));
        }
        System.out.println();
    }

    private String getDistanceBar(int distance) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < distance; i++){
            sb.append("-");
        }
        return sb.toString();
    }

    private void printWinner(List<String> winnerNames) {
        System.out.print("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
