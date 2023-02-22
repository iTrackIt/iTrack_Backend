package rw.iTrack.Application.v1.services;

import rw.iTrack.Application.v1.models.Event;

import java.util.List;
import java.util.UUID;

public interface EventService {

    public List<Event> getEventsByStudentId(UUID id);

}
