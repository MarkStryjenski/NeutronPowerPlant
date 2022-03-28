package com.Alarm.state;

public abstract class State {

    public SystemState systemState;

    public State(SystemState systemState) {
        this.systemState = systemState;
    }

    public abstract void onChangeState();
}
