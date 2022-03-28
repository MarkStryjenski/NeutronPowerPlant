package com.Decorator;

import com.Core;
import com.Decorator.Upgrades.EarlyWarningSystem;
import com.EnergyPackage;

public interface EnergyFactory {
    EnergyPackage harvestEnergy(int amount, Core core);
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
    void toWarning();
}
