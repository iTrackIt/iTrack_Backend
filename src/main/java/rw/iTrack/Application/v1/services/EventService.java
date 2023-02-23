package rw.iTrack.Application.v1.services;

import org.springframework.http.ResponseEntity;
import rw.iTrack.Application.v1.dto.CreateEventDTO;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.payload.ListApiResponse;

import java.util.UUID;

public interface EventService {
    public ResponseEntity<ListApiResponse> getAllEvents() throws Exception;
    public ResponseEntity<ApiResponse> getEventById(Long event_id) throws Exception;
    public ResponseEntity<ListApiResponse> getEventByEducator(Long educator_id) throws Exception;
    public ResponseEntity<ApiResponse> createEvent(CreateEventDTO eventDTO) throws Exception;
}
