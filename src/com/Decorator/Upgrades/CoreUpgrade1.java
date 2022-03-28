package com.Decorator.Upgrades;

import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;
import com.EnergyPackage;
import com.Materials.Material;

public class CoreUpgrade1 extends FactoryDecorator {

//    private EnergyFactory energyFactory;
    public CoreUpgrade1(EnergyFactory energyFactory) {
        super(energyFactory);
    }

    @Override
    public EnergyPackage harvestEnergy(int amount) {
        Material inputMaterial = this.core.getInputMaterial();
        if(inputMaterial instanceof com.Materials.neutronParticle || inputMaterial instanceof com.Materials.ProtonParticle){
            if(amount <= this.core.getMaximumCapacity()){
                double heatUnits = (double) Math.round((amount * inputMaterial.getHeatPerUnit()*100)/100);
                double steamUnits = (double) Math.round((amount * inputMaterial.getSteamPerUnit()*100)/100);
                double energyUnits = (double) Math.round((amount * inputMaterial.getEnergyPerUnit())*100)/100;
                return new EnergyPackage(energyUnits, heatUnits, steamUnits);
            }
            return null;
        }
        return null;
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
