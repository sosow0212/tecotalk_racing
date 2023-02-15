package utils;

import domain.Player;
import domain.Players;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersFactory {

    private static final int DEFAULT_DISTANCE_VALUE = 0;

    public static Players createPlayers(final String[] playerNames) {
        List<Player> players = makeCars(playerNames);
        return new Players(players);
    }

    private static List<Player> makeCars(final String[] playerNames) {
        return Arrays.stream(playerNames)
                .map(PlayersFactory::makeCar)
                .collect(Collectors.toList());
    }

    private static Player makeCar(final String playerName) {
        return new Player(playerName, DEFAULT_DISTANCE_VALUE);
    }
}
