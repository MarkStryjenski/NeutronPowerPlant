package com.Alarm.state;

import com.Alarm.AlarmSystem;

public class Warning extends State {

    public Warning(AlarmSystem alarmSystem) {
        super(alarmSystem);
    }

    @Override
    public void onChangeState() {
        alarmSystem.changeState(new Warning(alarmSystem));
    }
}
