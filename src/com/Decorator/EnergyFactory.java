package com.Decorator;

public interface EnergyFactory {
    Double produceEnergy();
    void activateAlert();
    void storeEnergy();
    void sllStoredEnergy();
    void checkState();
    void checkTemperature();
    void releasePressure();
    void increaseProduction();
    boolean explodePowerPlant();
}
