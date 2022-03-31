package com.Decorator;




public abstract class FactoryDecorator implements EnergyFactory {
    protected EnergyFactory energyFactory;

    public FactoryDecorator(EnergyFactory energyFactory) {
         this.energyFactory = energyFactory;
    }
}
