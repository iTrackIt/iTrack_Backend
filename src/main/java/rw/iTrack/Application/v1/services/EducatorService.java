package rw.iTrack.Application.v1.services;

import org.springframework.http.ResponseEntity;
import rw.iTrack.Application.v1.models.Educator;

import java.util.List;
import java.util.UUID;

public interface EducatorService {

    public ResponseEntity<List<Educator>> getAllEducators() throws Exception;
    public ResponseEntity<Educator> getEducatorById(UUID educ_id) throws Exception;
}
