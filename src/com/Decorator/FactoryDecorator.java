package com.Decorator;


public abstract class FactoryDecorator {
    public EnergyFactory energyFactory;

    public FactoryDecorator(EnergyFactory energyFactory) {
        this.energyFactory = energyFactory;
    }
}
