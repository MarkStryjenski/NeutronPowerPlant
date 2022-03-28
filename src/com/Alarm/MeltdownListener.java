package com.Alarm;

import com.Alarm.state.State;


public class MeltdownListener implements AlarmListener {

    public MeltdownListener() {}

    @Override
    public void update(String eventType, State state) {
        System.out.println("Something changed! " + eventType + state);
    }
}
