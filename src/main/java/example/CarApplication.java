package example;

import java.util.Scanner;

class CarApplication {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        Car car = new Car();
        System.out.println("자동차를 몇 번 이동 시키겠습니까?");
        int orderedCount = read.nextInt();

        car.moveAsOrdered(orderedCount);
        System.out.println("자동차는 " + car.getPosition() + "번 움직였습니다.");
    }
}
