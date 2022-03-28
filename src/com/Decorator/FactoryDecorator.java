package com.Decorator;


public abstract class FactoryDecorator implements EnergyFactory {
    public EnergyFactory energyFactory;

    public FactoryDecorator(EnergyFactory energyFactory) {
        this.energyFactory = energyFactory;
    }

    @Override
    public Double produceEnergy() {
        return 1.0;
    }

    @Override
    public void activateAlert() {

    }

    @Override
    public void storeEnergy() {

    }

    @Override
    public void sllStoredEnergy() {

    }

    @Override
    public void checkState() {

    }

    @Override
    public void checkTemperature() {

    }

    @Override
    public void releasePressure() {

    }

    @Override
    public void increaseProduction() {

    }

    @Override
    public boolean explodePowerPlant() {
        return true;
    }

    ;
}
