package utils;

public class SplitPlayerNames {

    private static final String SPLIT_DELIMITER = ",";

    public static String[] splitCarNames(String carNames) {
        return carNames.split(SPLIT_DELIMITER);
    }
}
