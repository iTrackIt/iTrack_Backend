package rw.iTrack.Application.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<List<Educator>> getAllEducators() throws Exception{
        return educatorService.getAllEducators();
    }

    @GetMapping("/user/{educ_id}")
    public ResponseEntity<Educator> getEducatorById(@PathVariable UUID educ_id) throws Exception{
        return educatorService.getEducatorById(educ_id);
    }

}
