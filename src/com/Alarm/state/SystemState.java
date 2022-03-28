package com.Alarm.state;

public class SystemState {
    private State state;

    public SystemState() {
        this.state = new WorkingProperly(this);
    }

    public State getState() {
        return state;
    }
    public void changeState(State state) {
        this.state = state;
    }
}
