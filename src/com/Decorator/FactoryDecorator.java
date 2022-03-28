package com.Decorator;


import com.Core;
import com.EnergyPackage;

public abstract class FactoryDecorator implements EnergyFactory {
    protected EnergyFactory energyFactory;
    protected Core core;

    public FactoryDecorator(EnergyFactory energyFactory) {
        this.energyFactory = energyFactory;
    }

    public EnergyPackage harvestEnergy(int amount) {
        return energyFactory.harvestEnergy(amount);
    }

    public void activateAlert() {
        energyFactory.activateAlert();
    }

    public void storeEnergy() {

    }

    public void sllStoredEnergy() {

    }

    public void checkState() {

    }

    public void checkTemperature() {

    }

    public void releasePressure() {

    }

    public void increaseProduction() {

    }

    public boolean explodePowerPlant() {
        return true;
    }
}
