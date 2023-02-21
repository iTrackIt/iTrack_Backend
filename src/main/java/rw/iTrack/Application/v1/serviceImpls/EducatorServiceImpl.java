package rw.iTrack.Application.v1.serviceImpls;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import rw.iTrack.Application.v1.dto.EducatorDTO;
import rw.iTrack.Application.v1.dto.EducatorDTOMapper;
import rw.iTrack.Application.v1.models.Educator;
import rw.iTrack.Application.v1.repositories.EducatorRepository;
import rw.iTrack.Application.v1.services.EducatorService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class EducatorServiceImpl implements EducatorService {
    private final EducatorRepository educatorRepository;
    private final EducatorDTOMapper educatorDTOMapper;

    public EducatorServiceImpl(EducatorRepository  educatorRepository , EducatorDTOMapper educatorDTOMapper){
        this.educatorRepository = educatorRepository;
        this.educatorDTOMapper = educatorDTOMapper;
    }

    public ResponseEntity<List<EducatorDTO>> getAllEducators() throws Exception{
        try {
            List<Educator> educators = educatorRepository.findAll();
            return ResponseEntity.ok().body(educators
                    .stream()
                    .map(educatorDTOMapper)
                    .collect(Collectors.toList()));
        }catch (Exception e){
            throw new Exception(("Failed to get all educated"));
        }
    }

    public ResponseEntity<EducatorDTO> getEducatorById(UUID educ_id) throws Exception{
        if(educatorRepository.existsById(educ_id)){
            Optional<Educator> educator = (educatorRepository.findById(educ_id));
            return ResponseEntity.ok().body(educator.map(educatorDTOMapper).get());
        }else {
            throw new Exception("The user with id: " + educ_id + " does not exist");
        }
    }

    public ResponseEntity<EducatorDTO> deleteEducator(@PathVariable UUID educ_id) throws Exception{
        if(educatorRepository.existsById(educ_id)){
            try {
                Educator educator = (educatorRepository.findById(educ_id)).get();
                EducatorDTO educator1 = ((educatorRepository.findById(educ_id)).map(educatorDTOMapper)).get();
                educatorRepository.delete(educator);
                return ResponseEntity.ok().body(educator1);
            }catch (Exception e){
                throw new Exception("Failed to delete the educator");
            }
        }else {
            throw new Exception("The educator with id: " + educ_id + " does not exist");
        }
    }

    public  ResponseEntity<EducatorDTO> addEducator(@RequestBody Educator educator) throws Exception{
       Educator educator1 = (educatorRepository.findByEmail(educator.getEmail())).get();
       if(educator1 == null){
          return ResponseEntity.ok().body(educator);
           // TODO: 2/20/2023  Add a educator addition request
           // TODO: 2/20/2023 Add an educator creator from the dto request
           // TODO: 2/20/2023  Save the educator to the database
       }else{
           throw new Exception("The educator with email: " + educator1.getEmail() + " already exists");
       }
    }
}
