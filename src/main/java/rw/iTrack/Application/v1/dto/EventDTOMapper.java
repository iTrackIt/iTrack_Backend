package rw.iTrack.Application.v1.dto;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rw.iTrack.Application.v1.models.Event;
import rw.iTrack.Application.v1.repositories.EventRepository;

import java.util.function.Function;

@Component
public class EventDTOMapper implements Function<Event , EventDTO> {
    private final EventRepository eventRepository;

    public EventDTOMapper(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDTO apply(Event event) {
        return new EventDTO(
                event.getEvent_id(),
                event.getReason(),
                event.getMarks(),
                event.getTimeRemoved(),
                event.getEducator(),
                event.getStudent()
        );
    }
}
