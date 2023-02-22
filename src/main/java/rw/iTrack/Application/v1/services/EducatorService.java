package rw.iTrack.Application.v1.services;

import org.springframework.http.ResponseEntity;
import rw.iTrack.Application.v1.dto.CreateEducatorDTO;
import rw.iTrack.Application.v1.dto.EducatorDTO;
import rw.iTrack.Application.v1.payload.ApiResponse;
import java.util.List;
import java.util.UUID;

public interface EducatorService {
    public ResponseEntity<List<EducatorDTO>> getAllEducators() throws Exception;
    public ResponseEntity<ApiResponse> getEducatorById(UUID educ_id) throws Exception;
    public ResponseEntity<ApiResponse> deleteEducator(UUID educ_id) throws Exception;
    public  ResponseEntity<ApiResponse> addEducator(CreateEducatorDTO educator) throws Exception;
    public  ResponseEntity<ApiResponse> updateEducator(UUID educ_id , CreateEducatorDTO educatorDTO) throws Exception;
}
