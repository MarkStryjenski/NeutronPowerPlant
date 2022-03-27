package com.Alarm.state;

import com.Alarm.AlarmSystem;

public class WorkingProperly extends State {

    public WorkingProperly(AlarmSystem alarmSystem) {
        super(alarmSystem);
    }

    @Override
    public void onChangeState() {
        alarmSystem.changeState(new WorkingProperly(alarmSystem));
    }
}
