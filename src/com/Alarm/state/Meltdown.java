package com.Alarm.state;

import com.Alarm.AlarmSystem;

public class Meltdown extends State {

    public Meltdown(AlarmSystem alarmSystem) {
        super(alarmSystem);
    }

    @Override
    public void onChangeState() {
        alarmSystem.changeState(new WorkingProperly(alarmSystem));
    }
}
