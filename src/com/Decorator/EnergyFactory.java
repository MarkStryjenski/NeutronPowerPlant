package com.Decorator;

import com.EnergyPackage;

public interface EnergyFactory {
    EnergyPackage harvestEnergy(int amount);
    default void activateAlert(){
        System.out.println("activate alert defulat interface");
    }
    //void activateAlert();
    void storeEnergy();
    void sllStoredEnergy();
    void checkState();
    void checkTemperature();
    void releasePressure();
    void increaseProduction();
    boolean explodePowerPlant();
}
