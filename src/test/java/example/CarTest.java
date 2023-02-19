package example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private final StrongPowerMaker strongPowerMaker = new StrongPowerMaker();

    @Test
    @DisplayName("power가 4 이상이면 자동차는 움직인다.")
    void car_moves_if_power_enough() {
        // given
        Car car = new Car();
        int expectedResult = 1;

        // when
        car.move(strongPowerMaker);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("자동차는 명령을 받은 만큼 이동거리가 증가한다.")
    void car_moves_as_ordered() {
        int orderedCount = 10;
        Car car = new Car();
        car.moveAsOrdered(orderedCount);
        int distanceResult = car.getPosition();
        assertThat(distanceResult).isEqualTo(orderedCount);
    }

    @Test
    @DisplayName("자동차는 명령을 받은 만큼 이동거리가 증가한다. given/when/then 패턴 적용")
    void car_moves_as_ordered2() {
        // given (주어진 값)
        int orderedCount = 10;
        Car car = new Car();

        // when (기능 작동)
        car.moveAsOrdered(orderedCount);
        int distanceResult = car.getPosition();

        // then (기능 작동 후 검증)
        assertThat(distanceResult).isEqualTo(orderedCount);
    }

    @Test
    @DisplayName("자동차를 이동 시킬 거리는 1 이상 10 이하의 수만 가능하다. (0 입력)")
    void throws_exception_when_order_count_invalid_1() {
        // given
        String expectedErrorMessage = "이동 시킬 거리는 1 이상 10 이하의 수만 가능합니다.";
        Car car = new Car();
        int orderCount = 0;

        // when & then
        assertThatThrownBy(() -> car.moveAsOrdered(orderCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @Test
    @DisplayName("자동차를 이동 시킬 거리는 1 이상 10 이하의 수만 가능하다. (11 입력)")
    void throws_exception_when_order_count_invalid_2() {
        // given
        String expectedErrorMessage = "이동 시킬 거리는 1 이상 10 이하의 수만 가능합니다.";
        Car car = new Car();
        int orderCount = 11;

        // when & then
        assertThatThrownBy(() -> car.moveAsOrdered(orderCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 11, 12})
    @DisplayName("자동차를 이동 시킬 거리가 1 이상 10 이하의 수가 아니면 예외가 발생한다.")
    void throws_exception_when_order_count_invalid(int givenOrderCount) {
        // given
        String expectedErrorMessage = "이동 시킬 거리는 1 이상 10 이하의 수만 가능합니다.";
        Car car = new Car();

        // when & then
        assertThatThrownBy(() -> car.moveAsOrdered(givenOrderCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedErrorMessage);
    }
}
