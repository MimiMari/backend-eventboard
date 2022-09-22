package de.marie.eventboard.service;

import de.marie.eventboard.dto.EventDto;
import de.marie.eventboard.model.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class Mapper {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public EventDto convertEntityToDto(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setTitle(event.getTitle());
        eventDto.setDescription(event.getDescription());
        eventDto.setPlace(event.getPlace());
        eventDto.setDate(event.getDate().format(formatter));

        return eventDto;
    }

    public Event convertDtoToEntity(EventDto eventDto) {
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setPlace(eventDto.getPlace());
        event.setDate(LocalDateTime.parse(eventDto.getDate()));
        return event;
    }
}
