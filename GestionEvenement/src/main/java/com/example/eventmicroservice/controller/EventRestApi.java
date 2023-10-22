package com.example.eventmicroservice.controller;

import com.example.eventmicroservice.entity.Event;
import com.example.eventmicroservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventRestApi {
    @Autowired
    private EventService eventService;


    @GetMapping("/list")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/get/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable Integer eventId) {
        Optional<Event> eventOptional = eventService.getEventById(eventId);
        return eventOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @PutMapping("/update/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable Integer eventId, @RequestBody Event updatedEvent) {
        Event result = eventService.updateEvent(eventId, updatedEvent);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Integer eventId) {
        String resultMessage = eventService.deleteEvent(eventId);
        if ("event deleted".equals(resultMessage)) {
            return ResponseEntity.ok(resultMessage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
