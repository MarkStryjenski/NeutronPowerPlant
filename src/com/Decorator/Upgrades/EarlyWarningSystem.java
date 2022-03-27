package com.Decorator.Upgrades;

import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;

public class EarlyWarningSystem extends FactoryDecorator {
    public EarlyWarningSystem(EnergyFactory energyFactory) {
        super(energyFactory);
    }

    @Override
    public void activateAlert(){

    }
}
