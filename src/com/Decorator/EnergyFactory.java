package com.Decorator;

import com.Alarm.AlarmSystem;
import com.Alarm.state.Meltdown;
import com.Alarm.state.State;
import com.Core;
import com.EnergyPackage;

import java.util.ArrayList;

public interface EnergyFactory{
    void harvestEnergyNew(int amount);
    default void activateAlert(){
        System.out.println("activate alert defulat interface");
    }
    void setTotalUnits(EnergyPackage energyPackage);
    void setCore(Core core);
    ArrayList<Core> getCores();
    AlarmSystem getAlarmSystem();
    int getPlantLevel();
    void setPlantLevel(int newLevel);

    State getPowerPlantState();

    void stateHasChanged(String eventType, State state);

    void setPowerPlantState(State newState);

    double getTotalHeatUnits();

    double getTotalSteamUnits();

    int getWarningCount();

    void increaseWarningCount();
}
