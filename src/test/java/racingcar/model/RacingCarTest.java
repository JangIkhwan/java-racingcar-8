package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    @DisplayName("전진하면 거리가 1 증가한다")
    @Test
    void shouldIncreaseDistanceWhenGoForward(){
        // given
        final String name = "슈퍼카";
        RacingCar car = new RacingCar(name);

        // when
        car.goForward();

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }
}