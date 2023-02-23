package rw.iTrack.Application.v1.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import rw.iTrack.Application.v1.dto.CreateEventDTO;
import rw.iTrack.Application.v1.models.Event;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.payload.ListApiResponse;
import java.util.List;

public interface EventService {
    public List<Event> getEventsByStudentId(Long id);
    public ResponseEntity<ListApiResponse> getAllEvents() throws Exception;
    public ResponseEntity<ApiResponse> getEventById(Long event_id) throws Exception;
    public ResponseEntity<ListApiResponse> getEventByEducator(Long educator_id) throws Exception;
    public ResponseEntity<ApiResponse> createEvent(CreateEventDTO eventDTO) throws Exception;
    public ResponseEntity<ApiResponse> deleteEvent(Long event_id) throws Exception;
}
