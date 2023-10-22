package com.example.eventmicroservice.service;

import com.example.eventmicroservice.entity.Event;
import com.example.eventmicroservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private  EventRepository eventRepository;



    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Integer eventId) {
        return eventRepository.findById(eventId);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Integer eventId, Event updatedEvent) {
        if (eventRepository.existsById(eventId)) {
            updatedEvent.setEventId(eventId);
            return eventRepository.save(updatedEvent);
        } else {
            return null;
        }
    }

    public String deleteEvent(Integer eventId) {
        if (eventRepository.existsById(eventId)) {
            eventRepository.deleteById(eventId);
            return "event deleted";
        }
        else{
            return "event not deleted";

        }
    }
}
