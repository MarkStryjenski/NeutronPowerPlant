package com.Decorator.Upgrades;

import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;

public class CoreUpgrade1 extends FactoryDecorator {

//    private EnergyFactory energyFactory;
    public CoreUpgrade1(EnergyFactory energyFactory) {
        super(energyFactory);
    }

    @Override
    public Double produceEnergy() {
        return 2.0;
    }

//    public isCoreUpgrade1Implemented(){
//
//    }

    public EnergyFactory getEnergyFactory() {
        return energyFactory;
    }

    public void setEnergyFactory(EnergyFactory energyFactory) {
        this.energyFactory = energyFactory;
    }
}
