package com.Decorator.Upgrades;

import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;

public class CoreUpgrade1 extends FactoryDecorator {

    private EnergyFactory energyFactory;
    public CoreUpgrade1(EnergyFactory energyFactory) {
        super(energyFactory);
    }

    @Override
    public Double produceEnergy() {
        return 2.0;
    }

}
