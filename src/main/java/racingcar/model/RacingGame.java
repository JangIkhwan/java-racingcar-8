package racingcar.model;

import racingcar.model.dto.*;
import racingcar.model.strategy.CarMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private RacingCarList carList;
    private int moveNumber;

    public RacingGame(CarNameList carNameList, MoveNumber moveNumber, CarMovingStrategy movingStrategy){
        this.carList = new RacingCarList(carNameList, movingStrategy);
        this.moveNumber = moveNumber.getValue();
    }

    public GameResult play() {
        List<GameState> gameStates = new ArrayList<>();
        for(int move = 0; move < moveNumber; move++){
            carList.moveCars();
            gameStates.add(carList.getState());
        }
        return new GameResult(gameStates, carList.getWinnerNames());
    }
}
