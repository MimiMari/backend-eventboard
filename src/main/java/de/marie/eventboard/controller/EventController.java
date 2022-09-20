package de.marie.eventboard.controller;

import de.marie.eventboard.model.Event;
import de.marie.eventboard.repository.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return this.eventRepository.findAll();
    }

    @PostMapping("/event")
    public Event createEvents(@RequestBody Event event) {
        return this.eventRepository.save(event);
    }
}
