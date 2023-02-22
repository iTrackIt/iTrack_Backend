package rw.iTrack.Application.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.iTrack.Application.v1.models.Educator;
import rw.iTrack.Application.v1.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event , Long> {
    Optional<List<Event>> findByEducator(Educator educator);
}

