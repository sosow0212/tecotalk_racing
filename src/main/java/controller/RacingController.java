package controller;

import domain.Players;
import domain.TryCount;
import java.util.InputMismatchException;
import utils.PlayersFactory;
import view.InputView;
import view.OutputView;

public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Players players = getPlayers();
        TryCount tryCount = getTryCount();

        distruptByOdo();

        startRace(players, tryCount);
        outputView.printWinners(players);
    }

    private void distruptByOdo() {
        int temp = 0;
        for (int i = 1; i <= 3; i++) {
            outputView.printOdoSays(i);
            temp = inputView.inputOdo();
        }
        outputView.printOdoEnd();
    }

    private Players getPlayers() {
        outputView.requestOfCarNames();

        try {
            final String[] playerNames = inputView.inputCarNames();
            Players players = PlayersFactory.createPlayers(playerNames);
            return players;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getPlayers();
        }
    }

    private TryCount getTryCount() {
        outputView.requestOfTryCount();

        try {
            int input = inputView.inputTryCount();
            TryCount tryCount = new TryCount(input);
            return tryCount;
        } catch (IllegalArgumentException | InputMismatchException exception) {
            System.out.println(exception.getMessage());
            return getTryCount();
        }
    }

    private void startRace(Players players, TryCount tryCount) {
        outputView.printResultMessage();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            players.moveAll();
            outputView.printCurrentRacingStatus(players);
        }
    }
}
