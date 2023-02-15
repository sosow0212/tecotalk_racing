package domain;

public class Player {

    private final PlayerName playerName;
    private int distance;

    public Player(final String name, int distance) {
        this.playerName = new PlayerName(name);
        this.distance = distance;
    }

    public void move() {
        if(this.playerName.getName().startsWith("R")) {
            this.distance += 3;
        }

        if(this.playerName.getName().startsWith("T")) {
            this.distance += 3;
        }
    }

    public String getName() {
        return this.playerName.getName();
    }

    public int getDistance() {
        return this.distance;
    }
}
