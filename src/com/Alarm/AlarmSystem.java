package com.Alarm;

import com.Alarm.state.State;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class AlarmSystem {
    private final Map<String, List<AlarmListener>> listeners = new HashMap<>();

    public AlarmSystem(String... operations) {

        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, AlarmListener listener) {
        List<AlarmListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, AlarmListener listener) {
        List<AlarmListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, State state) {
        List<AlarmListener> users = listeners.get(eventType);
        for (AlarmListener listener : users) {
            listener.update(eventType, state);
        }
    }

}
