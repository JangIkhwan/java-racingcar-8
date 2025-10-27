package racingcar.model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @DisplayName("이름의 길이가 1자 이상 5자 이하면 자동차 이름 생성에 성공한다")
    void shouldCreateCarNameWhenNameIsValid(){
        // given
        final String name = "name";

        // when
        CarName carName = new CarName(name);

        // then
        assertThat(carName.getValue()).isEqualTo(name);
    }

    @DisplayName("이름의 길이가 1자 미만이거나 5자를 초과하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", ""})
    void shouldThrowExceptionWhenNameIsInvalid(String names){
        // when & then
        assertThatThrownBy(() -> new CarName(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 같으면 같은 객체다")
    @Test
    void shouldEqualToAnotherWhenNameIsSame(){
        // given
        final String name = "name";
        CarName one = new CarName(name);
        CarName another = new CarName(name);

        // when & then
        assertThat(one.equals(another)).isTrue();
    }

    @DisplayName("이름이 다르면 다른 객체다")
    @Test
    void shouldNotEqualToAnotherWhenNameIsDifferent(){
        // given
        CarName one = new CarName("car1");
        CarName another = new CarName("car2");

        // when & then
        assertThat(one.equals(another)).isFalse();
    }
}