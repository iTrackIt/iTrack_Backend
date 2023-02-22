package rw.iTrack.Application.v1.dto;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import rw.iTrack.Application.v1.models.Event;

import java.util.function.Function;

@Component
public class EventDTOMapper implements Function<Event , EventDTO> {
    @Override
    public EventDTO apply(Event event) {
        return new EventDTO(
                event.getReason(),
                event.getMarks(),
                event.getTimeRemoved(),
                event.getEducator(),
                event.getStudent()
        );
    }
}
