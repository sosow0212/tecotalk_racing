package view;

import utils.ScannerUtil;
import utils.SplitPlayerNames;

public class InputView {

    public String[] inputCarNames() {
        final String carNames = ScannerUtil.readLine();
        return SplitPlayerNames.splitCarNames(carNames);
    }

    public int inputTryCount() {
        return ScannerUtil.readNumber();
    }

    public int inputOdo() {
        return ScannerUtil.readNumber();
    }
}
