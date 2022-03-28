package com.Decorator;


public abstract class FactoryDecorator implements EnergyFactory {
    protected EnergyFactory energyFactory;

    public FactoryDecorator(EnergyFactory energyFactory) {
        this.energyFactory = energyFactory;
    }

    public Double produceEnergy() {
        return energyFactory.produceEnergy();
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
