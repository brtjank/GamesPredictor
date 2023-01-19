package com.brtjank.gamespredictor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brtjank.gamespredictor.models.Competitor;

public interface CompetitorRepository extends JpaRepository<Competitor, Long> {
    
}
