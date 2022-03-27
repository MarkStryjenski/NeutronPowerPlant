package com.Decorator.Upgrades;

import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;

public class CoreUpgrade1 extends FactoryDecorator {
    public CoreUpgrade1(EnergyFactory energyFactory) {
        super(energyFactory);
    }
}
