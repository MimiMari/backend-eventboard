package de.marie.eventboard.service;

import de.marie.eventboard.dto.EventDto;
import de.marie.eventboard.model.Event;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Data
public class Mapper {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public EventDto convertEntityToDto(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setTitle(event.getTitle());
        eventDto.setDescription(event.getDescription());
        eventDto.setPlace(event.getPlace());
        eventDto.setGuid(event.getGuid());
        eventDto.setDate(event.getDate().format(formatter));

        return eventDto;
    }

    public Event convertDtoToEntity(EventDto eventDto) {
        Event event = new Event();
        event.setGuid(String.valueOf(UUID.randomUUID()));
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setPlace(eventDto.getPlace());
        event.setDate(LocalDateTime.parse(eventDto.getDate()));
        return event;
    }
}
