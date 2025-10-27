package racingcar.model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoveNumberTest {
    @DisplayName("수가 자연수이면 전진횟수 객체를 생성한다")
    @Test
    void shouldCreateWhenNumberIsNaturalNumber(){
        // given
        final int number = 1;

        // when & then
        assertDoesNotThrow(() -> new MoveNumber(number));
    }

    @DisplayName("수가 자연수가 아니면 전진횟수 객체를 생성한다")
    @Test
    void shouldThrowExceptionWhenNumberIsNotNaturalNumber(){
        // given
        final int number = 0;

        // when & then
        assertThatThrownBy(() -> new MoveNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}