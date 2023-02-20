package rw.iTrack.Application.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.iTrack.Application.v1.models.Event;

public interface EventRepository extends JpaRepository<Event , Long> {
}

