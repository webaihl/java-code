package org.example.design.creatation.factory.factorymethod;

public class WulinVanCarFactory extends AbstractCarFactory {
    @Override
    public AbstractCar newCar() {
        return new VanCar();
    }
}
