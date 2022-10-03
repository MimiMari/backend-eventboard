package de.marie.eventboard.service;

import de.marie.eventboard.dto.EventDto;
import de.marie.eventboard.exception.EventNotFoundException;
import de.marie.eventboard.model.Event;
import de.marie.eventboard.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final Mapper mapper;

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository, Mapper mapper) {
        this.mapper = mapper;
        this.eventRepository = eventRepository;
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

    public EventDto getEventById(String guid) {

        return eventRepository.findOneByGuid(guid)
                .map(event -> mapper.convertEntityToDto(event))
                .orElseThrow(() -> new EventNotFoundException(guid));
    }

    public Event updateEvent(EventDto eventDto, String guid) {

        return eventRepository.findOneByGuid(guid)
                .map(event -> {
                    event.setDescription(eventDto.getDescription());
                    event.setTitle(eventDto.getTitle());
                    event.setDate(LocalDateTime.parse(eventDto.getDate()));
                    event.setPlace(eventDto.getPlace());
                    event.setGuid(eventDto.getGuid());
                    return eventRepository.save(event);
                }).orElseThrow(() -> new EventNotFoundException(guid));

    }

    public String deleteUserByGuid(String guid) {
        if (eventRepository.findOneByGuid(guid).isPresent()) {
        eventRepository.delete(eventRepository.findOneByGuid(guid).get());
        return "Event with guid " + guid + " has been deleted.";

        } else {
            throw new EventNotFoundException(guid);
        }
    }
}
