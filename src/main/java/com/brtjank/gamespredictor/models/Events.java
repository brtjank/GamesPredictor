package com.brtjank.gamespredictor.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Events {
    @JsonProperty("Events")
    private ArrayList<Event> events;

    public Event get(int index){
        return events.get(index);
    }

    public String getMultiplePredictions(int number) {
        int i = 0;
        String predictions = "";

        while (i < number)
        {
            if (i < events.size()) {
                Event event = events.get(i);
                predictions += event.getPrediction();
            }
            else {
                predictions += "\n\nNumber too big. Printing predictions for all of the games\n";
                break;
            }
            i = i + 1;
        }

        return predictions;
    }
}
