package racingcar.model;

import racingcar.model.dto.CarName;
import racingcar.model.dto.CarState;
import racingcar.model.strategy.CarMovingStrategy;

public class RacingCar {
    private String name;
    private int distance;
    private CarMovingStrategy movingStrategy;

    public RacingCar(CarName name, CarMovingStrategy movingStrategy) {
        this.name = name.getValue();
        this.distance = 0;
        this.movingStrategy = movingStrategy;
    }

    public void move(){
        if (movingStrategy.movable()){
            goForward();
        }
    }

    public void goForward() {
        this.distance++;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public CarState getState() {
        return new CarState(getName(), getDistance());
    }
}
