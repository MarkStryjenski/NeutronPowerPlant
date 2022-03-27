package com.Decorator.Upgrades;

import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;

public class FacilitySafetyUpgrade extends FactoryDecorator {
    public FacilitySafetyUpgrade(EnergyFactory energyFactory) {
        super(energyFactory);
    }
}
