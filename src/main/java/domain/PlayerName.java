package domain;

public class PlayerName {

    private static final int CAR_NAME_LENGTH_MAX = 5;

    private final String name;

    public PlayerName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (!(name.startsWith("R") || name.startsWith("T"))) {
            throw new IllegalArgumentException("선수의 이름은 'R' 혹은 'T'로 시작해야합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
