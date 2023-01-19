package com.brtjank.gamespredictor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brtjank.gamespredictor.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    
}
