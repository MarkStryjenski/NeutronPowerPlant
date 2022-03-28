package com.Alarm.state;

public class Meltdown extends State {

    public Meltdown(SystemState systemState) {
        super(systemState);
    }

    @Override
    public void onChangeState() {
        systemState.changeState(new Meltdown(systemState));
    }
}
