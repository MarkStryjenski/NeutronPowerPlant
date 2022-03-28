package com.Decorator.Upgrades;

import com.Alarm.AlarmSystem;
import com.Decorator.EnergyFactory;
import com.Decorator.FactoryDecorator;

public class EarlyWarningSystem extends FactoryDecorator {

    private AlarmSystem alarmSystem;

    public EarlyWarningSystem(EnergyFactory energyFactory,AlarmSystem alarmSystem) {
        super(energyFactory);
        this.alarmSystem=alarmSystem;
    }

    @Override
    public void activateAlert(){

    }


}
