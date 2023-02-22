package rw.iTrack.Application.v1.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rw.iTrack.Application.v1.dto.CreateEducatorDTO;
import rw.iTrack.Application.v1.dto.EducatorDTO;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.serviceImpls.EducatorServiceImpl;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/educator")
public class EducatorController {

    @Autowired
    private final EducatorServiceImpl educatorService;

    public EducatorController(EducatorServiceImpl educatorService){
        this.educatorService = educatorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EducatorDTO>> getAllEducators() throws Exception{
        return educatorService.getAllEducators();
    }

    @GetMapping("/{educ_id}")
    public ResponseEntity<ApiResponse> getEducatorById(@PathVariable UUID educ_id) throws Exception{
        return educatorService.getEducatorById(educ_id);
    }

    @PostMapping("/create")
    public  ResponseEntity<ApiResponse> addEducator(@RequestBody CreateEducatorDTO educator) throws Exception{
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/educator").toString());
        return educatorService.addEducator(educator);
    }

    @PutMapping("/{educ_id}")
    public ResponseEntity<ApiResponse> updateEducator( @PathVariable UUID educ_id ,  @RequestBody CreateEducatorDTO educatorDTO) throws Exception{
        return educatorService.updateEducator(educ_id ,  educatorDTO);
    }

    @DeleteMapping("/{educ_id}")
    public ResponseEntity<ApiResponse> deleteEducator(@PathVariable UUID educ_id) throws Exception{
      return educatorService.deleteEducator(educ_id);
    }
}
