package rw.iTrack.Application.v1.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import rw.iTrack.Application.v1.models.Educator;

import java.util.List;
import java.util.UUID;

public interface EducatorService {

    public ResponseEntity<List<Educator>> getAllEducators() throws Exception;
    public ResponseEntity<Educator> getEducatorById(UUID educ_id) throws Exception;
    public ResponseEntity<Educator> deleteEducator(UUID educ_id) throws Exception;
    public  ResponseEntity<Educator> addEducator(Educator educator) throws Exception;
}
