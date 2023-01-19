package com.brtjank.gamespredictor.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.JoinColumn;

@Entity
@Table (name = "event")
public class Event {
    
    @Id
    @Column
    @JsonProperty("sport_event_id")
    private String id;
    @Column
    @JsonProperty("start_date")
    private Date startDate;
    @Column
    @JsonProperty("sport_name")
    private String sportName;
    @Column
    @JsonProperty("competition_name")
    private String competitionName;
    @Column
    @JsonProperty("competition_id")
    private String competitionId;
    @Column
    @JsonProperty("season_name")
    private String seasonName;
    @JsonProperty("competitors")
    private List<Competitor> competitors;
    @Column
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventCompetitor> event_competitors;
    @ManyToOne
    @JoinColumn(name = "venue")
    @JsonProperty("venue")
    private Venue venue;
    @Column
    @JsonProperty("probability_home_team_winner")
    private Double probabilityHome;
    @Column
    @JsonProperty("probability_draw")
    private Double probabilityDraw;
    @Column
    @JsonProperty("probability_away_team_winner")
    private Double probabilityAway;

    public Venue getVenue(){
        return this.venue;
    }

    public List<Competitor> getCompetitors(){
        return this.competitors;
    }

    public String getPrediction(){
        String prediction = "\n\nStart date: " + startDate + 
            ",\n" + competitionName +
            ",\n" + competitors.get(0).getName() + " (" + competitors.get(0).getCountry() + ") vs. " +
            competitors.get(1).getName() + " (" + competitors.get(1).getCountry() + ") " + 
            ",\nVenue: ";
            
        if (venue != null){
            prediction += venue.getName();
        }
        else {
            prediction += "Unknown";
        }
        prediction += ",\nHighest probable result: " + this.getResult();

        return prediction;
    }

    public String getResult(){
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
                "\n competitors=" + competitors +
                "\n venue_id=" + venue +
                "\n probability_home_team_winner=" + probabilityHome +
                "\n probability_draw=" + probabilityDraw +
                "\n probability_away_team_winner=" + probabilityAway +
                '}';
    }
}
