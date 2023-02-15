package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PlayersTest {

    @Test
    @DisplayName("코코닥의 요구사항에 맞게, 토끼와 거북이는 한 번 이동시마다 +3씩 거리가 증가한다!")
    void test_moveAll() {
        // given (테스트를 위해 준비된 데이터 및 환경)
        int defaultDistance = 0;
        int expectedDistance = 3; // 기능 작동 후 예상하는 이동 거리

        Player rabbit = new Player("Rabbit", defaultDistance);
        Player turtle = new Player("Turtle", defaultDistance);
        List<Player> participants = List.of(rabbit, turtle);
        Players racingPlayers = new Players(participants);

        // when (테스트 대상에게 메서드를 실행한다. == 기능을 동작한다.)
        racingPlayers.moveAll();

        // then (기능 동작 후, 의도한 결과가 나왔는지 검증한다.)
        // 검증 1. 토끼의 이동 후 거리는 expectedDistance 변수의 값과 동일하다.
        assertThat(rabbit.getDistance()).isEqualTo(expectedDistance);

        // 검증 1. 거북이의 이동 후 거리는 expectedDistance 변수의 값과 동일하다.
        assertThat(turtle.getDistance()).isEqualTo(expectedDistance);
    }
}
