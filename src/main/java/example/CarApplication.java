package example;

import java.util.Scanner;

class CarApplication {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        Car car = new Car();
        car.move(new RandomPowerMaker());
        System.out.println("자동차는 " + car.getPosition() + "번 움직였습니다.");
    }
}
