package rw.iTrack.Application.v1.serviceImpls;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import rw.iTrack.Application.v1.dto.EventDTOMapper;
import rw.iTrack.Application.v1.models.Event;
import rw.iTrack.Application.v1.payload.ListApiResponse;
import rw.iTrack.Application.v1.repositories.EventRepository;
import rw.iTrack.Application.v1.services.EventService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventDTOMapper eventDTOMapper;

    public EventServiceImpl(EventRepository eventRepository , EventDTOMapper eventDTOMapper){
        this.eventRepository = eventRepository;
        this.eventDTOMapper = eventDTOMapper;
    }
    public ResponseEntity<ListApiResponse> getAllEvents() throws Exception{
        try {
            List<Event> eventList = eventRepository.findAll();
            return ResponseEntity.ok().body(new ListApiResponse(
                    true,
                    "Successfully retrieved all the events",
                    eventList.stream().map(eventDTOMapper).collect(Collectors.toList())
            ));
        }catch (Exception e){
            return ResponseEntity.status(500).body(new ListApiResponse(
                    false,
                    "Failed to fetch all events"
            ));
        }
    }
}
