package com.Decorator.Upgrades;

import com.Alarm.AlarmSystem;
import com.Core;
import com.Alarm.state.SystemState;
import com.Alarm.state.Warning;
import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;
import com.EnergyPackage;

public class EarlyWarningSystem extends FactoryDecorator {

    private AlarmSystem alarmSystem;
    private SystemState systemState;
    private Warning warning;

    public EarlyWarningSystem(EnergyFactory energyFactory,AlarmSystem alarmSystem) {
        super(energyFactory);
        this.alarmSystem=alarmSystem;
        this.systemState = new SystemState();
        this.warning = new Warning(systemState);
    }

    @Override
    public void toWarning() {
        this.systemState.changeState(this.warning);
        alarmSystem.notify("warning", this.warning);
    }

    @Override
    public EnergyPackage harvestEnergy(int amount, Core core)
    {
        return null;
    }

    @Override
    public void activateAlert(){
        System.out.println("Activating override alert BIDUBIDUBIDU");
    }

    @Override
    public void storeEnergy()
    {

    }

    @Override
    public void sllStoredEnergy()
    {

    }

    @Override
    public void checkState()
    {

    }

    @Override
    public void checkTemperature()
    {

    }

    @Override
    public void releasePressure()
    {

    }

    @Override
    public void increaseProduction()
    {

    }

    @Override
    public boolean explodePowerPlant()
    {
        return false;
    }
}
