package rw.iTrack.Application.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.payload.ListApiResponse;
import rw.iTrack.Application.v1.serviceImpls.EventServiceImpl;

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
}
