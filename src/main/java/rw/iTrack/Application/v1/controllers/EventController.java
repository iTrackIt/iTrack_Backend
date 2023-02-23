package rw.iTrack.Application.v1.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rw.iTrack.Application.v1.dto.CreateEventDTO;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.payload.ListApiResponse;
import rw.iTrack.Application.v1.serviceImpls.EventServiceImpl;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    @Autowired
    private final EventServiceImpl eventService;
    public EventController(EventServiceImpl eventService){
        this.eventService = eventService;
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
    public ResponseEntity<ListApiResponse> getEventByEducator(@PathVariable UUID educator_id) throws Exception{
        return eventService.getEventByEducator(educator_id);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> addEvent(@RequestBody CreateEventDTO eventDTO) throws Exception{
        return eventService.createEvent(eventDTO);
    }
}
