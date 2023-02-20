package rw.iTrack.Application.v1.serviceImpls;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import rw.iTrack.Application.v1.models.Educator;
import rw.iTrack.Application.v1.repositories.EducatorRepository;
import rw.iTrack.Application.v1.services.EducatorService;

import java.util.List;
import java.util.UUID;

@Component
public class EducatorServiceImpl implements EducatorService {
    private final EducatorRepository educatorRepository;

    public EducatorServiceImpl(EducatorRepository educatorRepository){
        this.educatorRepository = educatorRepository;
    }

    public ResponseEntity<List<Educator>> getAllEducators() throws Exception{
        try {
            List<Educator> educators = educatorRepository.findAll();
            return ResponseEntity.ok().body(educators);
        }catch (Exception e){
            throw new Exception(("Failed to get all educated"));
        }
    }

    public ResponseEntity<Educator> getEducatorById(UUID educ_id) throws Exception{
        if(educatorRepository.existsById(educ_id)){
            Educator educator = (educatorRepository.findById(educ_id)).get();
            return ResponseEntity.ok().body(educator);
        }else {
            throw new Exception("The user with id: " + educ_id + " does not exist");
        }
    }
}