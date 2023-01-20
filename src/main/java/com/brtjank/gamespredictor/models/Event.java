package com.brtjank.gamespredictor.models;

import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    
    @JsonProperty("sport_event_id")
    private String id;
    @JsonProperty("start_date")
    private Date startDate;
    @JsonProperty("sport_name")
    private String sportName;
    @JsonProperty("competition_name")
    private String competitionName;
    @JsonProperty("competition_id")
    private String competitionId;
    @JsonProperty("season_name")
    private String seasonName;
    @JsonProperty("competitors")
    private Competitor[] competitors;
    @JsonProperty("venue")
    private Venue venue;
    @JsonProperty("probability_home_team_winner")
    private Double probabilityHome;
    @JsonProperty("probability_draw")
    private Double probabilityDraw;
    @JsonProperty("probability_away_team_winner")
    private Double probabilityAway;

    public Competitor getCompetitor1() {
        return this.competitors[0];
    }

    public Competitor getCompetitor2() {
        return this.competitors[1];
    }

    public String getCompetitionName() {
        return this.competitionName;
    }
    
    public String getPrediction() {
        String prediction = "\nStart date: " + startDate + 
            ",\n" + competitionName +
            ",\n" + competitors[0].getName() + " (" + competitors[0].getCountry() + ") vs. " +
            competitors[1].getName() + " (" + competitors[1].getCountry() + ")" + 
            ",\nVenue: ";
            
        if (venue != null){
            prediction += venue.getName();
        }
        else {
            prediction += "Unknown";
        }
        prediction += ",\nHighest probable result: " + this.getMostProbableResult();

        return prediction + "\n";
    }

    public String getMostProbableResult() {
        Double highest = 0.0;
        String result = "";
        if (probabilityHome > highest){
            highest = probabilityHome;
            result = "HOME_TEAM_WIN ";
        }
        if (probabilityDraw > highest){
            highest = probabilityDraw;
            result = "DRAW ";
        }
        if (probabilityAway > highest){
            highest = probabilityAway;
            result = "AWAY_TEAM_WIN ";
        }
        return result + "(" + highest + ")";
    }
    
    @Override
    public String toString() {
        return "Event {" +
                "id=" + id +
                "\n start_date='" + startDate + 
                "\n sport_name='" + sportName +
                "\n competition_name='" + competitionName +
                "\n competition_id=" + competitionId +
                "\n season_name=" + seasonName +
                "\n competitiors=" + Arrays.deepToString(competitors) +
                "\n venue_id=" + venue +
                "\n probability_home_team_winner=" + probabilityHome +
                "\n probability_draw=" + probabilityDraw +
                "\n probability_away_team_winner=" + probabilityAway +
                '}';
    }
}
