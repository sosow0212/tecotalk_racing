package example;

public class RandomPowerMaker implements PowerGenerator {

    @Override
    public int generate() {
        return (int) (Math.random() * 10);
    }
}
