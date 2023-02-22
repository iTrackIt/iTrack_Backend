package rw.iTrack.Application.v1.serviceImpls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.iTrack.Application.v1.models.Event;
import rw.iTrack.Application.v1.repositories.EventRepository;
import rw.iTrack.Application.v1.services.EventService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<Event> getEventsByStudentId(UUID id) {
        Optional<List<Event>> events = this.eventRepository.findByStudentId(id);
        return events.orElse(null);
    }

}
