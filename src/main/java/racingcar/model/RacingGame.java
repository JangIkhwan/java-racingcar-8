package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.dto.CarState;
import racingcar.model.dto.GameResult;
import racingcar.model.dto.GameState;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<RacingCar> cars = new ArrayList<>();
    private int moveNumber;

    public RacingGame(List<String> carNames, int moveNumber){
        for(String name : carNames){
            cars.add(new RacingCar(name));
        }
        this.moveNumber = moveNumber;
    }

    public GameResult play() {
        List<GameState> gameStates = new ArrayList<>();
        for(int move = 0; move < moveNumber; move++){
            moveCars();
            gameStates.add(getState());
        }
        return new GameResult(gameStates, getWinnerNames());
    }

    private void moveCars() {
        for(RacingCar car : cars){
            int rand = Randoms.pickNumberInRange(0, 9);
            if(rand >= 4) {
                car.goForward();
            }
        }
    }

    private GameState getState(){
        List<CarState> carStates = new ArrayList<>();
        for(RacingCar car : cars){
            carStates.add(new CarState(car.getName(), car.getDistance()));
        }
        return new GameState(carStates);
    }

    private List<String> getWinnerNames(){
        int maxDistance = 0;
        List<String> winnerNames = new ArrayList<>();
        for(RacingCar car : cars){
            if(maxDistance < car.getDistance()){
                winnerNames = new ArrayList<>();
                winnerNames.add(car.getName());
            }
            else if (maxDistance == car.getDistance()){
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
