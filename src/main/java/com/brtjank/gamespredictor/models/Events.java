package com.brtjank.gamespredictor.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Events {
    @JsonProperty("Events")
    private ArrayList<Event> events;

    public Event get(int index){
        return events.get(index);
    }
}
