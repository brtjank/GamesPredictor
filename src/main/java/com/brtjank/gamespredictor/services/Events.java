package com.brtjank.gamespredictor.services;

import java.util.ArrayList;

import com.brtjank.gamespredictor.models.Event;
import com.fasterxml.jackson.annotation.JsonProperty;

// ********************************************************************************
// Class made for storing a list of events and handling actions on multiple events
// ********************************************************************************

public class Events {
    @JsonProperty("Events")
    private ArrayList<Event> events;

    public Event get(int index){
        return this.events.get(index);
    }

    public int size() {
        return this.events.size();
    }

    // method returning games predictions for the first *number games on the list
    public String getMultiplePredictions(int number) {
        int i = 0;
        String predictions = "";
        
        if (number <= 0) {
            return "\nNumber is wrong. Not printing predictions\n";
        }

        while (i < number)
        {
            if (i < this.size()) {
                if (i == 0) {
                    predictions += "Printing " + number + " predictions:\n";
                }
                Event event = this.get(i);
                predictions += event.getPrediction();
            }
            else {
                predictions += "\nNumber of predictions that you wanted to print is too big. Printed predictions for all of the games\n";
                return predictions;
            }
            i = i + 1;
        }

        return predictions;
    }

    // method to store unique competition names in an arraylist
    public ArrayList<String> getCompetitionsNames() {
        ArrayList<String> competitions = new ArrayList<>();
        int i = 0;
		while (i < this.size()) {
			if (!competitions.contains(events.get(i).getCompetitionName())){
				competitions.add(events.get(i).getCompetitionName());
			}
			i += 1;
		}
        return competitions;
    }
}
