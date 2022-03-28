package com.Decorator;

import com.Alarm.AlarmSystem;
import com.Core;
import com.Decorator.Upgrades.EarlyWarningSystem;
import com.EnergyPackage;

public interface EnergyFactory extends com.Alarm.AlarmListener{
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
    void setTotalUnits(EnergyPackage energyPackage);
    void setCore(Core core);
    Core getCore();
    AlarmSystem getAlarmSystem();
}
