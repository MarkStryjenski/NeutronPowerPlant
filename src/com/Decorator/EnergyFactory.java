package com.Decorator;

import com.Alarm.AlarmSystem;
import com.Core;
import com.EnergyPackage;

public interface EnergyFactory extends com.Alarm.AlarmListener{
    EnergyPackage harvestEnergy(int amount, Core core);
    default void activateAlert(){
        System.out.println("activate alert defulat interface");
    }
    void toWarning();
    void setTotalUnits(EnergyPackage energyPackage);
    void setCore(Core core);
    Core getCore();
    AlarmSystem getAlarmSystem();
}
