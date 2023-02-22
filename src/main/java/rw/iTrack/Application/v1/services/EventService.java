package rw.iTrack.Application.v1.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.payload.ListApiResponse;

public interface EventService {
    public ResponseEntity<ListApiResponse> getAllEvents() throws Exception;
    public ResponseEntity<ApiResponse> getEventById(Long event_id) throws Exception;
}
