package com.Alarm.state;

public class WorkingProperly extends State {

    public WorkingProperly(SystemState systemState) {
        super(systemState);
    }

    @Override
    public void onChangeState() {
        systemState.changeState(new WorkingProperly(systemState));
    }
}
