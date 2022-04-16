package com.Alarm.state;

import com.Core;
import com.Decorator.EnergyFactory;
import com.PowerPlant;

public abstract class State {

    public EnergyFactory powerPlant;

    public State(EnergyFactory powerPlant) {
        this.powerPlant = powerPlant;
    }

    public abstract void onChangeState();

    //public PowerPlant getSystemState() {
    //    return powerPlant;
    //}

    public void setSystemState(PowerPlant powerPlant) {
        this.powerPlant = powerPlant;
    }

    public void energyHarvest(int amount, EnergyFactory plant, Core core){}

    public void notifyStateChange(String eventType, State state)
    {
        if(this.powerPlant.getAlarmSystem() != null)
        {
            this.powerPlant.stateHasChanged(eventType, state);
            return;
        }
        System.out.println("No alarm system built in. No notifications sent out.");
    }
}
