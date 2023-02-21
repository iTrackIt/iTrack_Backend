package rw.iTrack.Application.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.iTrack.Application.v1.dto.EducatorDTO;
import rw.iTrack.Application.v1.models.Educator;
import rw.iTrack.Application.v1.serviceImpls.EducatorServiceImpl;

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
    public  ResponseEntity<EducatorDTO> addEducator(@RequestBody Educator educator) throws Exception{
        // TODO: 2/20/2023 Get data from a creation dto and not a normal class
        // TODO: 2/20/2023 Create dto to add it to 
    return educatorService.addEducator(educator);
    }
    @DeleteMapping("/{educ_id}")
    public ResponseEntity<EducatorDTO> deleteEducator(@PathVariable UUID educ_id) throws Exception{
      return educatorService.deleteEducator(educ_id);
    }
}
