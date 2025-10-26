package racingcar.model.dto;

import java.util.ArrayList;
import java.util.List;

public class CarNameList {
    private List<CarName> carNames;

    public CarNameList(){
        carNames = new ArrayList<>();
    }

    public void add(CarName name){
        if(carNames.contains(name)){
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
        carNames.add(name);
    }

    public List<CarName> getCarNames(){
        return carNames;
    }

    public int length(){
        return this.getCarNames().size();
    }
}
