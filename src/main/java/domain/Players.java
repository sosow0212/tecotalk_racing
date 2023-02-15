package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Players {

    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = players;
    }

    public void moveAll() {
        players.stream()
                .forEach(player -> player.move());
    }

    public Map<String, Integer> getCurrentStatus() {
        Map<String, Integer> currentStatus = new HashMap<>();

        for (final Player player : players) {
            currentStatus.put(player.getName(), player.getDistance());
        }

        return currentStatus;
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        final int maxCountOfDistance = findMaxCountOfDistance();

        for (final Player player : players) {
            addWinnerName(winnerNames, player, maxCountOfDistance);
        }

        return winnerNames;
    }

    private int findMaxCountOfDistance() {
        int maxCountOfDistance = Integer.MIN_VALUE;

        for (final Player player : players) {
            maxCountOfDistance = Math.max(player.getDistance(), maxCountOfDistance);
        }

        return maxCountOfDistance;
    }

    private void addWinnerName(final List<String> winnerNames, final Player player, final int maxCountOfDistance) {
        if (player.getDistance() == maxCountOfDistance) {
            winnerNames.add(player.getName());
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
