package rw.iTrack.Application.v1.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import rw.iTrack.Application.v1.dto.CreateEducatorDTO;
import rw.iTrack.Application.v1.dto.EducatorDTO;
import rw.iTrack.Application.v1.models.Educator;

import java.util.List;
import java.util.UUID;

public interface EducatorService {
    public ResponseEntity<List<EducatorDTO>> getAllEducators() throws Exception;
    public ResponseEntity<EducatorDTO> getEducatorById(UUID educ_id) throws Exception;
    public ResponseEntity<EducatorDTO> deleteEducator(UUID educ_id) throws Exception;
    public  ResponseEntity<CreateEducatorDTO> addEducator(CreateEducatorDTO educator) throws Exception;
}
