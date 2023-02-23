package rw.iTrack.Application.v1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.iTrack.Application.v1.models.Event;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.serviceImpls.EventServiceImpl;
import org.springframework.web.bind.annotation.*;
import rw.iTrack.Application.v1.dto.CreateEventDTO;
import rw.iTrack.Application.v1.payload.ListApiResponse;
import java.util.List;


@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventServiceImpl eventService;

    @GetMapping("/get-by-student/{studentId}")
    public ResponseEntity<ApiResponse> getEventsByStudentId(@PathVariable(name = "studentId") Long studentID) {
        List<Event> events = this.eventService.getEventsByStudentId(studentID);
        if (events.size() == 0)
            return ResponseEntity.ok().body(new ApiResponse(true, "No event related to this student"));
        return ResponseEntity.ok().body(new ApiResponse(true, "Eventss fetched successfully", events));
    }

    @GetMapping("/all")
    public ResponseEntity<ListApiResponse> getAllEvents() throws Exception{
        return eventService.getAllEvents();
    }

    @GetMapping("/{event_id}")
    public ResponseEntity<ApiResponse> getEventById(@PathVariable Long event_id) throws Exception{
        return eventService.getEventById(event_id);
    }

    @GetMapping("/educator/{educator_id}")
    public ResponseEntity<ListApiResponse> getEventByEducator(@PathVariable Long educator_id) throws Exception{
        return eventService.getEventByEducator(educator_id);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> addEvent(@RequestBody CreateEventDTO eventDTO) throws Exception{
        return eventService.createEvent(eventDTO);
    }
}
