package rw.iTrack.Application.v1.controllers;

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

    @GetMapping
    public ResponseEntity<List<EducatorDTO>> getAllEducators() throws Exception{
        return educatorService.getAllEducators();
    }

    @GetMapping("/user/{educ_id}")
    public ResponseEntity<EducatorDTO> getEducatorById(@PathVariable UUID educ_id) throws Exception{
        return educatorService.getEducatorById(educ_id);
    }

    @PostMapping
    public  ResponseEntity<ApiResponse> addEducator(@RequestBody CreateEducatorDTO educator) throws Exception{
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/educator").toString());
        return ResponseEntity.created(uri).body(new ApiResponse(true , "Educator created successfully" , educatorService.addEducator(educator)));
    }

    @PutMapping("/{educ_id}")
    public ResponseEntity<EducatorDTO> updateEducator( @PathVariable UUID educ_id ,  @RequestBody CreateEducatorDTO educatorDTO) throws Exception{
        return ResponseEntity.ok().body(educatorService.updateEducator(educ_id ,  educatorDTO));
    }

    @DeleteMapping("/{educ_id}")
    public ResponseEntity<EducatorDTO> deleteEducator(@PathVariable UUID educ_id) throws Exception{
      return educatorService.deleteEducator(educ_id);
    }
}
