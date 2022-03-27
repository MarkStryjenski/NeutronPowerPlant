package com.Alarm.state;

import com.Alarm.AlarmSystem;

public abstract class State {

    public AlarmSystem alarmSystem;

    public State(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    public abstract void onChangeState();
}
