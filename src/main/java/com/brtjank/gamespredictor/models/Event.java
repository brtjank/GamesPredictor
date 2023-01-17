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
