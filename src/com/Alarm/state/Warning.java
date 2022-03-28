package com.Alarm.state;

public class Warning extends State {

    public Warning(SystemState systemState) {
        super(systemState);
    }

    @Override
    public void onChangeState() {
        systemState.changeState(new Warning(systemState));
    }
}
