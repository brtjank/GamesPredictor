package com.brtjank.gamespredictor.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Competitor implements Comparable<Competitor>{
 
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("abbreviation")
    private String abbreviation;
    @JsonProperty("qualifier")
    private String qualifier;
    @JsonProperty("gender")
    private String gender;

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
                ", gender=" + gender +
               '}';
    }

    @Override
    public int compareTo(Competitor o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals (Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Competitor)) {
            return false;
        }

        Competitor comp = (Competitor) o;
        return this.getName().compareTo(comp.getName()) == 0;
    }
}
