package com.Decorator.Upgrades;

import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;

public class AdvancedComputerSystems extends FactoryDecorator {
    public AdvancedComputerSystems(EnergyFactory energyFactory) {
        super(energyFactory);
    }
}
