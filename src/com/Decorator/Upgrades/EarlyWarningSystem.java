package com.Decorator.Upgrades;

import com.Alarm.AlarmSystem;
import com.Alarm.state.State;
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
    public Core getCore()
    {
        return energyFactory.getCore();
    }

    @Override
    public AlarmSystem getAlarmSystem()
    {
        return energyFactory.getAlarmSystem();
    }

    @Override
    public EnergyPackage harvestEnergy(int amount, Core core)
    {
        return energyFactory.harvestEnergy(amount, core);
    }

    @Override
    public void activateAlert(){
        System.out.println("Activating override alert BIDUBIDUBIDU");
    }

    @Override
    public void update(String eventType, State state)
    {
        energyFactory.update(eventType, state);
    }
}
