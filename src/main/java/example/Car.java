package example;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    // 명령한 수만큼 move() 메서드를 실행시키는 기능
    public void moveAsOrdered(final int orderCount) {
        this.position += orderCount;
    }

    public int getPosition() {
        return position;
    }
}

