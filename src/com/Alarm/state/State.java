package com.Alarm.state;

import com.Alarm.AlarmSystem;

public abstract class State {

    public SystemState systemState;

    public State(SystemState systemState) {
        this.systemState = systemState;
    }

    public abstract void onChangeState();
}
