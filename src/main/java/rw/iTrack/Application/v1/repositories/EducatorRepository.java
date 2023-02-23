package rw.iTrack.Application.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.iTrack.Application.v1.models.Educator;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EducatorRepository extends JpaRepository<Educator , UUID> {

    Optional<Educator> findByEmail(String email);

}
