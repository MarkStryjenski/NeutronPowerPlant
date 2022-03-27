package com.Alarm;

import com.Alarm.state.State;
import com.Alarm.state.WorkingProperly;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class AlarmSystem {
    private final Map<State, List<AlarmListener>> listeners = new HashMap<>();
    private State state;


    public AlarmSystem(State... operations) {
        this.state = new WorkingProperly(this);

        for (State operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void changeState(State state) {
        this.state = state;
        // check if state is bad if yes notifysubs.
    }

    public State getState() {
        return this.state;
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
