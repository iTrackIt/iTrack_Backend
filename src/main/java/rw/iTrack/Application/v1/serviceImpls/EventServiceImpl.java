package rw.iTrack.Application.v1.serviceImpls;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import rw.iTrack.Application.v1.dto.EventDTOMapper;
import rw.iTrack.Application.v1.models.Educator;
import rw.iTrack.Application.v1.models.Event;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.payload.ListApiResponse;
import rw.iTrack.Application.v1.repositories.EducatorRepository;
import rw.iTrack.Application.v1.repositories.EventRepository;
import rw.iTrack.Application.v1.services.EventService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventDTOMapper eventDTOMapper;
    private final EducatorRepository educatorRepository;

    public EventServiceImpl(EventRepository eventRepository , EventDTOMapper eventDTOMapper,
                            EducatorRepository educatorRepository){
        this.eventRepository = eventRepository;
        this.eventDTOMapper = eventDTOMapper;
        this.educatorRepository = educatorRepository;
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

    public ResponseEntity<ApiResponse> getEventById(Long event_id) throws Exception{
        if(eventRepository.existsById(event_id)){
            Optional<Event> event = eventRepository.findById(event_id);
            return ResponseEntity.ok().body(new ApiResponse(
                    true,
                    "Successfully retrieved the event",
                    event.map(eventDTOMapper)
            ));
        }else{
            return ResponseEntity.status(404).body(new ApiResponse(
                    false,
                    "The event with id: " + event_id + " does not exist"
             ));
        }
    }

    public ResponseEntity<ListApiResponse> getEventByEducator(UUID educator_id) throws Exception{
        if(educatorRepository.existsById(educator_id)){
            Educator educator = educatorRepository.findById(educator_id).get();
            List<Event> eventList = eventRepository.findByEducator(educator).get();
            return ResponseEntity.ok().body(new ListApiResponse(
                       true,
                    "Successfully got the events",
                        eventList.stream().map(eventDTOMapper).collect(Collectors.toList())
            ));
        }else{
            return ResponseEntity.status(404).body(new ListApiResponse(
                    false,
                    "The educator with id: " + educator_id + " was not found"
            ));
        }
    }
}
