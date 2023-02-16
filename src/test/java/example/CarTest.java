package example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

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
    @DisplayName("자동차는 명령을 받은 만큼 이동거리가 증가한다.g/w/t 패턴 적용")
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
}
