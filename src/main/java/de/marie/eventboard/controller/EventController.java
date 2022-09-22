package de.marie.eventboard.controller;

import de.marie.eventboard.dto.EventDto;
import de.marie.eventboard.model.Event;
import de.marie.eventboard.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<EventDto> getEvents() {

        return eventService.getAllEvents();
    }

    @PostMapping("/event")
    public Event createEvents(@RequestBody EventDto eventDto) {

        return eventService.createEvent(eventDto);
    }
}
