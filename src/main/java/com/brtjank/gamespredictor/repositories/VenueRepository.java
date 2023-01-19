package com.brtjank.gamespredictor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brtjank.gamespredictor.models.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    
}
