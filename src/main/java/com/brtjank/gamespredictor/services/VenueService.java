package com.brtjank.gamespredictor.services;

import com.brtjank.gamespredictor.models.Venue;
import com.brtjank.gamespredictor.repositories.VenueRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    
    @Autowired  
    VenueRepository venueRepository;  

    public List<Venue> getAllVenue()   
    {  
        List<Venue> venues = new ArrayList<Venue>();  
        venueRepository.findAll().forEach(venue -> venues.add(venue));  
        return venues;
    }  

    public Venue getVenueById(Long id)   
    {  
       return venueRepository.findById(id).get();  
    }  

    public void save(Venue venue)   
    {  
        venueRepository.save(venue);  
    }  

    public void delete(Long id)   
    {  
        venueRepository.deleteById(id);  
    }  
}
