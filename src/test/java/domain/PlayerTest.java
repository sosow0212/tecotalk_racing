package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"Turtle", "Tony", "Rabbit", "Ralph"})
    @DisplayName("선수의 이름은 'T' 혹은 'R'로 시작해야한다. (성공 경우)")
    void test_name_validate_success(String givenName) {
        // when
        PlayerName playerName = new PlayerName(givenName);

        // then
        assertThat(playerName.getName()).isEqualTo(givenName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Jay", "Odo", "Ure", "Kokodak", "Io"})
    @DisplayName("선수의 이름은 'T' 혹은 'R'로 시작해야한다. (실패 경우)")
    void test_name_validate_fail(String givenName) {
        // given
        String expectedErrorMessage = "선수의 이름은 'R' 혹은 'T'로 시작해야합니다.";

        // when & then
        assertThatThrownBy(() -> new PlayerName(givenName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }
}
