package de.marie.eventboard.service;

import de.marie.eventboard.dto.EventDto;
import de.marie.eventboard.model.Event;
import de.marie.eventboard.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {



    @Test
    void getAllEvents() {
    }

    @Test
    void createEvent() {
        Mapper mapper = new Mapper();

        Event event = new Event();
        event.setTitle("Party");
        event.setDate(LocalDateTime.of(2022, 9, 25, 11, 53, 00));
        event.setPlace("Hamburg");
        event.setDescription("Feiern und Tanzen");

        EventDto eventDto = new EventDto();
        eventDto.setTitle("Party");
        eventDto.setDate(String.valueOf(event.getDate()));
        eventDto.setPlace("Hamburg");
        eventDto.setDescription("Feiern und Tanzen");

        EventRepository eventRepository = Mockito.mock(EventRepository.class);
        EventService eventService = new EventService(eventRepository, mapper);

        eventService.createEvent(eventDto);

        Mockito.verify(eventRepository).save(event);
    }
}