package rw.iTrack.Application.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.iTrack.Application.v1.models.Student;


public interface StudentRepository extends JpaRepository<Student , Long> {
}
