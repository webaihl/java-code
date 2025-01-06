package org.example.design.creatation.factory.factorymethod;

/**
 * 一个工厂生产只生产指定的对象
 */
public class MainTest {

    public static void main(String[] args) {
        AbstractCarFactory carFactory = new WulinRacingCarFactory();
        AbstractCar abstractCar = carFactory.newCar();
        abstractCar.run();


        carFactory = new WulinVanCarFactory();
        AbstractCar abstractCar1 = carFactory.newCar();

        abstractCar1.run();
    }
}
