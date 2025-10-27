package racingcar.model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameListTest {
    @DisplayName("같은 자동차 이름이 없다면 리스트에 추가할 수 있다")
    @Test
    void shouldAddCarNameWhenNoDuplicateCarNameExists(){
        // given
        CarName carName1 = new CarName("car1");
        CarName carName2 = new CarName("car2");
        CarNameList carNameList = new CarNameList();
        carNameList.add(carName1);

        // when & then
        assertDoesNotThrow(()-> carNameList.add(carName2));
    }

    @DisplayName("같은 자동차 이름을 리스트에 추가하면 예외가 발생한다")
    @Test
    void shouldThrowExceptionWhenAddDuplicateCarName(){
        // given
        CarName carName1 = new CarName("car1");
        CarName carName2 = new CarName("car1");
        CarNameList carNameList = new CarNameList();
        carNameList.add(carName1);

        // when & then
        assertThatThrownBy(()-> carNameList.add(carName2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트의 길이를 반환한다")
    @Test
    void shouldReturnLength(){
        // given
        CarName carName1 = new CarName("car1");
        CarName carName2 = new CarName("car2");

        CarNameList carNameList = new CarNameList();
        carNameList.add(carName1);
        carNameList.add(carName2);

        // when & then
        assertThat(carNameList.length()).isEqualTo(2);
    }

    @DisplayName("자동차 이름을 반환한다")
    @Test
    void shouldReturnNames(){
        // given
        CarName carName1 = new CarName("car1");
        CarName carName2 = new CarName("car2");

        CarNameList carNameList = new CarNameList();
        carNameList.add(carName1);
        carNameList.add(carName2);

        // when & then
        assertThat(carNameList.getCarNames()).containsExactly(carName1, carName2);
    }
}