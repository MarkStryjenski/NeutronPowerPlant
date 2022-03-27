package com.Decorator;

public interface EnergyFactory {
    void produceEnergy();
    void activateAlert();
    void storeEnergy();
    void sllStoredEnergy();
    void checkState();
    void checkTemperature();
    void releasePressure();
    void increaseProduction();
}
