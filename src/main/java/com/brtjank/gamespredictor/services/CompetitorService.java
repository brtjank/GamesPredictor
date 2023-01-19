package com.brtjank.gamespredictor.services;

import com.brtjank.gamespredictor.models.Competitor;
import com.brtjank.gamespredictor.repositories.CompetitorRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitorService {
    
    @Autowired  
    CompetitorRepository competitorRepository;  

    public List<Competitor> getAllCompetitor()   
    {  
        List<Competitor> competitors = new ArrayList<Competitor>();  
        competitorRepository.findAll().forEach(competitor -> competitors.add(competitor));  
        return competitors;
    }  

    public Competitor getCompetitorById(Long id)   
    {  
       return competitorRepository.findById(id).get();  
    }  

    public void save(Competitor competitor)   
    {  
        competitorRepository.save(competitor);  
    }  

    public void delete(Long id)   
    {  
        competitorRepository.deleteById(id);  
    }  
}
