package de.marie.eventboard.service;

import de.marie.eventboard.dto.EventDto;
import de.marie.eventboard.model.Event;
import de.marie.eventboard.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

class EventServiceTest {

    Mapper mapper = new Mapper();
    private LocalDateTime date = LocalDateTime.of(2022, 9, 25, 11, 53, 00);

    private Event createTestEvent() {
        Event event = new Event();
        event.setTitle("Party");
        event.setDate(LocalDateTime.of(2022, 9, 25, 11, 53, 00));
        event.setPlace("Hamburg");
        event.setDescription("Feiern und Tanzen");
        return event;
    }

    private EventDto createTestEventDto() {
        EventDto eventDto = new EventDto();
        eventDto.setTitle("Party");
        eventDto.setDate(String.valueOf(date));
        eventDto.setPlace("Hamburg");
        eventDto.setDescription("Feiern und Tanzen");
        return eventDto;
    }

    @Test
    void getAllEvents() {
        EventRepository eventRepository = Mockito.mock(EventRepository.class);
        EventService eventService = new EventService(eventRepository, mapper);

        eventService.createEvent(createTestEventDto());
        eventService.getAllEvents();

        Mockito.verify(eventRepository).findAll();
    }

    @Test
    void createEvent() {
        EventRepository eventRepository = Mockito.mock(EventRepository.class);
        EventService eventService = new EventService(eventRepository, mapper);

        eventService.createEvent(createTestEventDto());

        Mockito.verify(eventRepository).save(createTestEvent());
    }
}