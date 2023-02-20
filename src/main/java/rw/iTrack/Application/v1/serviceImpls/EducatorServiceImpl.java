package rw.iTrack.Application.v1.serviceImpls;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    public ResponseEntity<Educator> deleteEducator(@PathVariable UUID educ_id) throws Exception{
        if(educatorRepository.existsById(educ_id)){
            try {
                Educator educator = (educatorRepository.findById(educ_id)).get();
                educatorRepository.delete(educator);
                return ResponseEntity.ok().body(educator);
            }catch (Exception e){
                throw new Exception("Failed to delete the educator");
            }
        }else {
            throw new Exception("The educator with id: " + educ_id + " does not exist");
        }
    }

    public  ResponseEntity<Educator> addEducator(@RequestBody Educator educator) throws Exception{
       Educator educator1 = (educatorRepository.findByEmail(educator.getEmail())).get();
       if(educator1 == null){
          return ResponseEntity.ok().body(educator);
       }else{
           throw new Exception("The educator with email: " + educator1.getEmail() + " already exists");
       }
    }
}
