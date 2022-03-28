package com.Alarm;

import com.Alarm.state.State;

public interface AlarmListener {
    void update(String eventType, State state);
}
