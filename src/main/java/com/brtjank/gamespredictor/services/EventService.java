package com.brtjank.gamespredictor.services;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brtjank.gamespredictor.models.Event;
import com.brtjank.gamespredictor.repositories.EventRepository;

@Service
public class EventService {
    
    @Autowired  
    EventRepository eventRepository;  

    public List<Event> getAllEvent()   
    {  
        List<Event> events = new ArrayList<Event>();  
        eventRepository.findAll().forEach(event -> events.add(event));  
        return events;
    }  

    public Event getEventById(Long id)   
    {  
       return eventRepository.findById(id).get();  
    }  

    public void save(Event event)   
    {  
        eventRepository.save(event);  
    }  

    public void delete(Long id)   
    {  
        eventRepository.deleteById(id);  
    }  
}
