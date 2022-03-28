package com.Alarm;

import com.Alarm.state.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class AlarmSystem {
    private final Map<State, List<AlarmListener>> listeners = new HashMap<>();

    private WorkingProperly workingProperly;
    private Meltdown meltdown;
    private Warning warning;
    private SystemState systemState;

    public AlarmSystem(State... operations) {
        this.systemState = new SystemState();
        this.workingProperly = new WorkingProperly(systemState);
        this.workingProperly.onChangeState();
        System.out.println(this.systemState.getState());
        for (State operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(State eventType, AlarmListener listener) {
        List<AlarmListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(State eventType, AlarmListener listener) {
        List<AlarmListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(State eventType) {
        List<AlarmListener> users = listeners.get(eventType);
        for (AlarmListener listener : users) {
            listener.update(eventType);
        }
    }

}
