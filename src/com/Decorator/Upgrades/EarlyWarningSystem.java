package com.Decorator.Upgrades;

import com.Alarm.AlarmSystem;
import com.Alarm.state.State;
import com.Core;
import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;
import com.EnergyPackage;

import java.util.ArrayList;

public class EarlyWarningSystem extends FactoryDecorator {

    private AlarmSystem alarmSystem;
    //private SystemState systemState;

    public EarlyWarningSystem(EnergyFactory energyFactory,AlarmSystem alarmSystem) {
        super(energyFactory);
        this.alarmSystem = alarmSystem;
    }

    @Override
    public void setTotalUnits(EnergyPackage energyPackage)
    {
        energyFactory.setTotalUnits(energyPackage);
    }

    @Override
    public void setCore(Core core)
    {
        energyFactory.setCore(core);
    }

    @Override
    public ArrayList<Core> getCores()
    {
        return energyFactory.getCores();
    }

    @Override
    public AlarmSystem getAlarmSystem()
    {
        return this.alarmSystem;
    }

    @Override
    public void harvestEnergyNew(int amount)
    {
        energyFactory.harvestEnergyNew(amount);
    }

    @Override
    public int getPlantLevel() {
        return this.energyFactory.getPlantLevel();
    }

    @Override
    public void setPlantLevel(int newLevel) {
        this.energyFactory.setPlantLevel(newLevel);
    }

    @Override
    public State getPowerPlantState() {
        return this.energyFactory.getPowerPlantState();
    }

    @Override
    public void stateHasChanged(String eventType, State state) {
        this.energyFactory.stateHasChanged(eventType, state);
    }

    @Override
    public void setPowerPlantState(State newState) {
        this.energyFactory.setPowerPlantState(newState);
    }

    @Override
    public double getTotalHeatUnits() {
        return energyFactory.getTotalHeatUnits();
    }

    @Override
    public double getTotalSteamUnits() {
        return energyFactory.getTotalSteamUnits();
    }

    @Override
    public int getWarningCount() {
        return energyFactory.getWarningCount();
    }

    @Override
    public void increaseWarningCount() {
        energyFactory.increaseWarningCount();
    }
}
