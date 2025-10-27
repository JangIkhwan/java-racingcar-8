package racingcar.model.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMovingStrategyImpl implements CarMovingStrategy{
    public boolean movable() {
        int number = Randoms.pickNumberInRange(0, 9);
        if(number >= 4){
            return true;
        }
        return false;
    }
}
