package com.Decorator.Upgrades;

import com.Alarm.AlarmSystem;
import com.Alarm.state.SystemState;
import com.Alarm.state.Warning;
import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;

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

    public void toWarning() {
        this.systemState.changeState(this.warning);
        alarmSystem.notify("warning", this.warning);
    }

    @Override
    public void activateAlert(){
        System.out.println("Activating override alert BIDUBIDUBIDU");
    }
}
