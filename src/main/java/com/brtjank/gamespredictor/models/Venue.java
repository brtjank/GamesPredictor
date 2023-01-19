package com.brtjank.gamespredictor.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table (name = "venue")
@Entity
public class Venue {
    
    @Column
    @Id
    @JsonProperty("id")
    private String id;
    @Column
    @JsonProperty("name")
    private String name;
    @Column
    @JsonProperty("capacity")
    private Long capacity;
    @Column
    @JsonProperty("city_name")
    private String cityName;
    @Column
    @JsonProperty("country_name")
    private String countryName;
    @Column
    @JsonProperty("map_coordinates")
    private String mapCoordinates;
    @Column
    @JsonProperty("country_code")
    private String countryCode;
    @Column
    @OneToMany (mappedBy = "venue", cascade = CascadeType.ALL)
    private Event[] events;

    public String getName() {
        return this.name;
    }
    
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
