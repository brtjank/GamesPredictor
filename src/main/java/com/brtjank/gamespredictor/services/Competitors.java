package com.brtjank.gamespredictor.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.brtjank.gamespredictor.models.Competitor;

// ********************************************************************************
// Class made for storing a list of competitors and handling actions on multiple competitors
// ********************************************************************************

public class Competitors {
    
    ArrayList<Competitor> competitors = new ArrayList<>();
    
    public Competitor get(int index){
        return this.competitors.get(index);
    }

    // method to add unique competitors objects from a given competition to a list
    // if no competition is given as an argument (string is empty), then it adds all of the competitors
    public void addCompetitors(Events events, String competitionName) {
        int i = 0;
		while (i < events.size()) {
            if (competitionName != "") {
                if (events.get(i).getCompetitionName().equals(competitionName)) {
                    if (!competitors.contains(events.get(i).getCompetitor1())){
                        competitors.add(events.get(i).getCompetitor1());
                    }
                    if (!competitors.contains(events.get(i).getCompetitor2())){
                        competitors.add(events.get(i).getCompetitor2());
                    }
                }
            }
            else {
                if (!competitors.contains(events.get(i).getCompetitor1())){
                    competitors.add(events.get(i).getCompetitor1());
                }
                if (!competitors.contains(events.get(i).getCompetitor2())){
                    competitors.add(events.get(i).getCompetitor2());
                }
            }
			i += 1;
		}
    }

    // writing alphabetically sorted list of competitors to a file from an argument
    // if no competition is given as an argument (string is empty), then it writes all of the competitors
    public void printSorted(String competitionName, FileWriter myWriter) {
            try {
                if (competitionName != "") {
                    myWriter.write("Teams competing in: " + competitionName);
                    Collections.sort(competitors);
                    competitors.forEach((c) -> {
                        try {
                            myWriter.write(c.getName() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
                else {
                    myWriter.write("Printing all teams: \n");
                    Collections.sort(competitors);
                    competitors.forEach((c) -> {
                        try {
                            myWriter.write(c.getName() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
                myWriter.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
