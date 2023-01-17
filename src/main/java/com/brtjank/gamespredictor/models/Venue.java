package com.brtjank.gamespredictor.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Venue {
    
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("capacity")
    private Long capacity;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("map_coordinates")
    private String mapCoordinates;
    @JsonProperty("country_code")
    private String countryCode;

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + id +
                ", name='" + name + 
                ", capacity='" + capacity + 
                ", city_name='" + cityName + 
                ", country_name=" + countryName +
                ", map_coordinates=" + mapCoordinates +
                ", country_code=" + countryCode +
               '}';
    }
}
