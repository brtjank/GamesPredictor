package com.brtjank.gamespredictor.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "competitor")
public class Competitor {
 
    @Id
    @Column
    @JsonProperty("id")
    private String id;
    @Column
    @JsonProperty("name")
    private String name;
    @Column
    @JsonProperty("country")
    private String country;
    @Column
    @JsonProperty("country_code")
    private String countryCode;
    @Column
    @JsonProperty("abbreviation")
    private String abbreviation;
    @Column
    @JsonProperty("qualifier")
    private String qualifier;
    @Column
    @JsonProperty("gender")
    private String gender;
    @Column
    @OneToMany (mappedBy = "competitor", cascade = CascadeType.ALL)
    private List<EventCompetitor> event_competitors;

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "id=" + id +
                ", name='" + name + 
                ", country='" + country + 
                ", country_code='" + countryCode + 
                ", abbreviation=" + abbreviation +
                ", qualifier=" + qualifier +
                ", gender=" + gender +
               '}';
    }
}
