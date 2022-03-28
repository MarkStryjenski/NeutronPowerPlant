package com.Decorator;


import com.Core;
import com.EnergyPackage;

public abstract class FactoryDecorator implements EnergyFactory {
    protected EnergyFactory energyFactory;
    protected Core core;

    public FactoryDecorator(EnergyFactory energyFactory) {
        this.energyFactory = energyFactory;
    }
}
