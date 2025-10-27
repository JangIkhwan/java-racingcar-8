package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("두 개의 자동차가 겨루어도 정상 동작한다")
    @Test
    void shouldRunWhenTwoCarsAreGiven() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "pobi : --", "woni : --", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @DisplayName("세 개의 자동차가 겨루어도 정상 동작한다")
    @Test
    void shouldRunWhenThreeCarsAreGiven() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,hwani", "3");
                    assertThat(output()).contains("pobi : -", "woni : -", "hwani : -", "pobi : --", "최종 우승자 : pobi");
                    assertThat(output()).doesNotContain("woni : --", "hwani : --");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, STOP, STOP
        );
    }

    @DisplayName("자동차 이름의 길이가 1자 미만이거나 5자를 초과하면 벗어나면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef,abc", ",abc", "", ",", "abc,"})
    void shouldThrowExceptionWhenCarNameIsInvalid(String names){
        assertSimpleTest(()->
                assertThatThrownBy(() -> runException(names, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("중복되는 자동차 이름이 존재하면 예외가 발생한다")
    @Test
    void shouldThrowExceptionWhenDuplicateNameExists(){
        assertSimpleTest(()->
            assertThatThrownBy(() -> runException("abc,abc", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("전진 횟수가 자연수가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"3.14", "하나", "1개", "-1"})
    void shouldThrowExceptionWhenMoveNumberIsNotInteger(String number){
        assertSimpleTest(()->
            assertThatThrownBy(() -> runException("abc,abcd", number))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
