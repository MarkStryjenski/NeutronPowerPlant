package com.Decorator.Upgrades;

import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;
import com.EnergyPackage;
import com.Materials.Material;

public class CoreUpgrade2 extends FactoryDecorator {
    public CoreUpgrade2(EnergyFactory energyFactory) {
        super(energyFactory);
    }

    @Override
    public EnergyPackage harvestEnergy(int amount) {
        Material inputMaterial = this.core.getInputMaterial();
        if(amount <= this.core.getMaximumCapacity()){
            double heatUnits = (double) Math.round((amount * inputMaterial.getHeatPerUnit()*100)/100);
            double steamUnits = (double) Math.round((amount * inputMaterial.getSteamPerUnit()*100)/100);
            double energyUnits = (double) Math.round((amount * inputMaterial.getEnergyPerUnit())*100)/100;
            return new EnergyPackage(energyUnits, heatUnits, steamUnits);
        }
        return null;
    }
}
