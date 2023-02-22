package rw.iTrack.Application.v1.services;

import org.springframework.http.ResponseEntity;
import rw.iTrack.Application.v1.dto.CreateEducatorDTO;
import rw.iTrack.Application.v1.dto.EducatorDTO;

import java.util.List;
import java.util.UUID;

public interface EducatorService {
    public ResponseEntity<List<EducatorDTO>> getAllEducators() throws Exception;
    public ResponseEntity<EducatorDTO> getEducatorById(UUID educ_id) throws Exception;
    public ResponseEntity<EducatorDTO> deleteEducator(UUID educ_id) throws Exception;
    public  CreateEducatorDTO addEducator(CreateEducatorDTO educator) throws Exception;
    public  EducatorDTO updateEducator(UUID educ_id , CreateEducatorDTO educatorDTO) throws Exception;
}
