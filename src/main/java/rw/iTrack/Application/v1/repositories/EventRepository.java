package rw.iTrack.Application.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rw.iTrack.Application.v1.models.Educator;
import rw.iTrack.Application.v1.models.Event;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE  e.student=(SELECT s FROM Student s WHERE s.id=:id)")
    public Optional<List<Event>> findByStudentId(Long id);

    Optional<List<Event>> findByEducator(Educator educator);
}

