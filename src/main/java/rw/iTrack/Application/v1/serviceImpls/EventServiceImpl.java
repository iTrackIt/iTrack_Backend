package rw.iTrack.Application.v1.serviceImpls;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.iTrack.Application.v1.models.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import rw.iTrack.Application.v1.dto.CreateEventDTO;
import rw.iTrack.Application.v1.dto.EventDTOMapper;
import rw.iTrack.Application.v1.models.Educator;
import rw.iTrack.Application.v1.models.Student;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.payload.ListApiResponse;
import rw.iTrack.Application.v1.repositories.EducatorRepository;
import rw.iTrack.Application.v1.repositories.EventRepository;
import rw.iTrack.Application.v1.repositories.StudentRepository;
import rw.iTrack.Application.v1.services.EventService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventDTOMapper eventDTOMapper;
    private final EducatorRepository educatorRepository;
    private final StudentRepository studentRepository;

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

    public ResponseEntity<ListApiResponse> getEventByEducator(Long educator_id) throws Exception{
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

    public ResponseEntity<ApiResponse> createEvent(CreateEventDTO eventDTO) throws Exception {
        if(studentRepository.existsById(eventDTO.getStudent_id())){
            if(educatorRepository.existsById(eventDTO.getEducator_id())){
                Educator educator = educatorRepository.findById(eventDTO.getEducator_id()).get();
                Student student = studentRepository.findById(eventDTO.getStudent_id()).get();
                Event event = new Event(
                      eventDTO.getReason(),
                        eventDTO.getMarks(),
                        eventDTO.getTimeRemoved(),
                        educator,
                        student
                );
                try {
                    eventRepository.save(event);
                    return ResponseEntity.ok().body(new ApiResponse(
                            true,
                            "Successfully Created an event",
                            eventDTO
                    ));
                }catch (Exception e){
                    return ResponseEntity.status(500).body(new ApiResponse(
                            false,
                            "Failed to save the event"
                    ));
                }
            }else{
                return ResponseEntity.status(404).body(new ApiResponse(
                        false,
                        "The Educator with id: " + eventDTO.getEducator_id() +  " does not exist"
                ));
            }
        }else{
            return ResponseEntity.status(404).body(new ApiResponse(
                    false,
                    "The student with id: " + eventDTO.getStudent_id() +  " does not exist"
            ));
        }
    }

    @Override
    public List<Event> getEventsByStudentId(Long id) {
        Optional<List<Event>> events = this.eventRepository.findByStudentId(id);
        return events.orElse(null);
    }

}
