package domain;

public class Player {

    private final String name;
    private int distance;

    public Player(final String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move() {
        if(this.name.startsWith("R")) {
            this.distance += 3;
        }

        if(this.name.startsWith("T")) {
            this.distance += 3;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
