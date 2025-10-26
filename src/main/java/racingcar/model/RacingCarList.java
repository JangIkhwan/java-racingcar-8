package racingcar.model;

import racingcar.model.dto.CarName;
import racingcar.model.dto.CarNameList;
import racingcar.model.dto.CarState;
import racingcar.model.dto.GameState;
import racingcar.model.strategy.CarMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCarList(CarNameList carNameList, CarMovingStrategy movingStrategy){
        if(carNameList.length() <= 0){
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다.");
        }
        for(CarName name : carNameList.getCarNames())
            this.racingCars.add(new RacingCar(name, movingStrategy));
    }

    public void moveCars() {
        for(RacingCar car : racingCars){
            car.move();
        }
    }

    public GameState getState(){
        List<CarState> carStates = new ArrayList<>();
        for(RacingCar car : racingCars){
            carStates.add(car.getState());
        }
        return new GameState(carStates);
    }

    public List<String> getWinnerNames(){
        int maxDistance = 0;
        List<String> winnerNames = new ArrayList<>();
        for(RacingCar car : racingCars){
            if(maxDistance < car.getDistance()){
                winnerNames = new ArrayList<>();
                winnerNames.add(car.getName());
                maxDistance = car.getDistance();
            }
            else if (maxDistance == car.getDistance()){
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
