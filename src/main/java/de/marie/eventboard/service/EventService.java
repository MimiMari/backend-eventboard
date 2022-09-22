package de.marie.eventboard.service;

import de.marie.eventboard.dto.EventDto;
import de.marie.eventboard.model.Event;
import de.marie.eventboard.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final Mapper mapper;

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository, Mapper mapper) {
        this.eventRepository = eventRepository;
        this.mapper = mapper;
    }

    public List<EventDto> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(event -> mapper.convertEntityToDto(event))
                .collect(Collectors.toList());
    }

    public Event createEvent(EventDto eventDto) {
        return eventRepository.save(mapper.convertDtoToEntity(eventDto));
    }
}
