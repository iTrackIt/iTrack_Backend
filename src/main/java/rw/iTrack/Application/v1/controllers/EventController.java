package rw.iTrack.Application.v1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.iTrack.Application.v1.models.Event;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.serviceImpls.EventServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventServiceImpl eventService;

    @GetMapping("/get-by-student/{studentId}")
    public ResponseEntity<ApiResponse> getEventsByStudentId(@PathVariable(name = "studentId") UUID studentID) {
        List<Event> events = this.eventService.getEventsByStudentId(studentID);
        if (events.size() == 0)
            return ResponseEntity.ok().body(new ApiResponse(true, "No event related to this student"));
        return ResponseEntity.ok().body(new ApiResponse(true, "Eventss fetched successfully", events));
    }

}
