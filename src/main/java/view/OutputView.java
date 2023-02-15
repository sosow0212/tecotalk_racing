package view;

import domain.Player;
import domain.Players;
import java.util.HashMap;
import java.util.Map;

public class OutputView {

    private static final String SEPARATOR = " : ";
    private static final String DELIMITER = ", ";
    private static final String MOVE_DISTANCE_SYMBOL = "-";
    private static final String NEW_LINE = System.lineSeparator();

    public void requestOfCarNames() {
        System.out.println("경주자의 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void requestOfTryCount() {
        System.out.println("경주를 시도할 회수는 몇회인가요?");
    }

    public void printResultMessage() {
        System.out.println(NEW_LINE + "실행 결과");
    }

    public void printWinners(final Players players) {
        System.out.print(String.join(DELIMITER, players.getWinnerNames()));
        System.out.println("가 최종 우승했습니다.");
    }

    public void printCurrentRacingStatus(final Players players) {
        final Map<String, Integer> currentRacingStatus = getCurrentRacingStatus(players);
        StringBuilder currentRacingStatusMessage = new StringBuilder();

        for (final String carName : currentRacingStatus.keySet()) {
            int countOfMovingDistance = currentRacingStatus.get(carName);
            currentRacingStatusMessage
                    .append(carName)
                    .append(SEPARATOR)
                    .append(MOVE_DISTANCE_SYMBOL.repeat(countOfMovingDistance))
                    .append(NEW_LINE);
        }

        System.out.println(currentRacingStatusMessage);
    }

    private Map<String, Integer> getCurrentRacingStatus(Players players) {
        Map<String, Integer> carAndDistanceStatus = new HashMap<>();

        for (final Player player : players.getPlayers()) {
            carAndDistanceStatus.put(player.getName(), player.getDistance());
        }

        return carAndDistanceStatus;
    }

    public void printOdoSays(int answer) {
        System.out.println("오도 : 낄낄낄, 프로그램의 결과를 보고 싶으면 '" + answer + "'을 입력해라!");
    }

    public void printOdoEnd() {
        StringBuilder says = new StringBuilder();

        says.append(".\n")
                .append(".\n")
                .append(".\n")
                .append("오도 : 낄낄낄, 프로그램의 결과를 보고 싶으면 '" + 100 + "'을 입력해라!\n")
                .append("100");

        System.out.println(says);
    }
}
