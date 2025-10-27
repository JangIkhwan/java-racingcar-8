package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.CarName;
import racingcar.model.dto.CarState;
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

    @DisplayName("먼 거리를 달린 자동차가 이긴다")
    @Test
    void shouldWinWhenDistanceIsLongerThanAnothers(){
        // given
        RacingCar one = new RacingCar(new CarName("car1"), () -> true);
        RacingCar another = new RacingCar(new CarName("car2"), () -> true);

        one.move();

        // when & then
        assertThat(one.win(another)).isTrue();
    }

    @DisplayName("같은 거리를 달린 자동차는 서로 비긴다")
    @Test
    void shouldDrawWhenDistanceIsSameAsAnothers(){
        // given
        RacingCar one = new RacingCar(new CarName("car1"), () -> true);
        RacingCar another = new RacingCar(new CarName("car2"), () -> true);

        one.move();
        another.move();

        // when & then
        assertThat(one.draw(another)).isTrue();
    }

    @DisplayName("상태를 반환한다")
    @Test
    void shouldReturnState(){
        // given
        RacingCar car = new RacingCar(new CarName("car1"), () -> true);

        car.move();

        // when
        CarState state = car.getState();

        // then
        assertThat(state.getName()).isEqualTo("car1");
        assertThat(state.getDistance()).isEqualTo(1);
    }
}