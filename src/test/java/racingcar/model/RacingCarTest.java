package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.CarName;
import racingcar.model.strategy.CarMovingStrategyImpl;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    @DisplayName("전진하면 거리가 1 증가한다")
    @Test
    void shouldIncreaseDistanceWhenGoForward(){
        // given
        final CarName name = new CarName("슈퍼카");
        final CarMovingStrategyImpl strategy = new CarMovingStrategyImpl();
        RacingCar car = new RacingCar(name, strategy);

        // when
        car.goForward();

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }
}