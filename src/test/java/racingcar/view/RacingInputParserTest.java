package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingInputParserTest {
    private RacingInputParser inputParser = new RacingInputParser();

    @DisplayName("자동차 이름이 1자 이상 5자 이하면 성공한다")
    @Test
    void shouldParseCarNamesWhenInputIsValid(){
        // given
        final String input = "abc,def";

        // when
        List<String> names = inputParser.parseCarNames(input);

        // then
        assertThat(names).containsExactly("abc", "def");
    }

    @DisplayName("자동차 이름의 길이가 1자 미만이거나 5자를 초과하면를 벗어나면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef,abc", ",abc"})
    void shouldThrowExceptionWhenCarNameIsInvalid(String names){
        assertThatThrownBy(() -> inputParser.parseCarNames(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 자동차 이름이 존재하면 예외가 발생한다")
    @Test
    void shouldParseCarNamesWhenNoDuplicateNameExists(){
        // given
        final String duplicateNames = "abcd,abc";

        // when
        List<String> names = inputParser.parseCarNames(duplicateNames);

        // then
        assertThat(names).containsExactly("abcd", "abc");
    }

    @DisplayName("중복되는 자동차 이름이 존재하면 예외가 발생한다")
    @Test
    void shouldThrowExceptionWhenDuplicateNameExists(){
        // given
        final String duplicateNames = "abc,abc";

        // when & then
        assertThatThrownBy(() -> inputParser.parseCarNames(duplicateNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldParseMoveNumberWhenNumberIsInteger(){
        // given
        final String line = "1";

        // when
        int moveNumber = inputParser.parseMoveNumber(line);

        // then
        assertThat(moveNumber).isEqualTo(1);
    }

    @DisplayName("전진 횟수가 자연수가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"3.14", "하나", "1개", "-1"})
    void shouldThrowExceptionWhenMoveNumberIsNotInteger(String number){
        assertThatThrownBy(() -> inputParser.parseMoveNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}