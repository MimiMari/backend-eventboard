package de.marie.eventboard.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class EventDto {

    private String title;
    private String place;
    private String description;
    private String date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDto eventDto = (EventDto) o;
        return Objects.equals(title, eventDto.title) && Objects.equals(place, eventDto.place) && Objects.equals(description, eventDto.description) && Objects.equals(date, eventDto.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, place, description, date);
    }
}
