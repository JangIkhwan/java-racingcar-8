package racingcar.model;

import racingcar.model.dto.CarName;

public class RacingCar {
    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public RacingCar(CarName name) {
        this.name = name.getValue();
        this.distance = 0;
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
}
