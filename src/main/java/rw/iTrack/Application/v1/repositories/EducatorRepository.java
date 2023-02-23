package rw.iTrack.Application.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.iTrack.Application.v1.models.Educator;

import java.util.Optional;

@Repository
public interface EducatorRepository extends JpaRepository<Educator , Long> {

    Optional<Educator> findByEmail(String email);

}
