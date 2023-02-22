package rw.iTrack.Application.v1.serviceImpls;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rw.iTrack.Application.v1.dto.CreateEducatorDTO;
import rw.iTrack.Application.v1.dto.EducatorDTO;
import rw.iTrack.Application.v1.dto.EducatorDTOMapper;
import rw.iTrack.Application.v1.models.Educator;
import rw.iTrack.Application.v1.payload.ApiResponse;
import rw.iTrack.Application.v1.repositories.EducatorRepository;
import rw.iTrack.Application.v1.services.EducatorService;
import rw.iTrack.Application.v1.utils.Encoder;

import java.net.URI;
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

    public ResponseEntity<ApiResponse> getEducatorById(UUID educ_id) throws Exception{
        if(educatorRepository.existsById(educ_id)){
            Optional<Educator> educator = (educatorRepository.findById(educ_id));
            return ResponseEntity.ok().body(new ApiResponse(true , "Successfully retrieved the educator" , educator.map(educatorDTOMapper).get()));
        }else {
            return ResponseEntity.status(404).body(new ApiResponse(
                    false,
                    "The user with id: " + educ_id + " does not exist"
            ));
        }
    }

    public ResponseEntity<ApiResponse> deleteEducator(@PathVariable UUID educ_id) throws Exception{
        if(educatorRepository.existsById(educ_id)){
            try {
                Educator educator = (educatorRepository.findById(educ_id)).get();
                EducatorDTO educator1 = ((educatorRepository.findById(educ_id)).map(educatorDTOMapper)).get();
                educatorRepository.delete(educator);
                return ResponseEntity.ok().body(new ApiResponse(
                        true,
                        "Deleting the user successfully",
                        educator1
                ));
            }catch (Exception e){
               return ResponseEntity.status(500).body(new ApiResponse(
                       false,
                       "Failed to delete the user with the given id"
               ));
            }
        }else {
            return ResponseEntity.status(404).body(new ApiResponse(
                    false,
                    "The user with id: " + educ_id + " does not exist"
            ));
        }
    }

    public  ResponseEntity<ApiResponse> addEducator(@RequestBody CreateEducatorDTO educator) throws Exception{
       Optional<Educator> educator2 = educatorRepository.findByEmail(educator.getEmail());
       if(!educator2.isPresent()){
           Educator educator3 = new Educator(
                   educator.getFullNames(),
                   educator.getUsername(),
                   educator.getEmail(),
                   educator.getNational_id(),
                   educator.getGender(),
                   educator.getPassword()
           );
           try {
               Encoder encoder = new Encoder();
               educator3.setPassword(encoder.hashPassword(educator3.getPassword()));
               educatorRepository.save(educator3);
               URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/educator").toString());
               return ResponseEntity.created(uri).body(new ApiResponse(true , "Educator created successfully" , educator));
           }catch (Exception e){
               return ResponseEntity.status(500).body(new ApiResponse(
                       false,
                       "Failed to add the new Educator"
               ));
           }
       }else{
           return ResponseEntity.status(404).body(new ApiResponse(
                   false,
                   "The educator with email: " + educator2.get().getEmail() + " already exists"
           ));
       }
    }

    @Transactional
    public ResponseEntity<ApiResponse> updateEducator(UUID educ_id , CreateEducatorDTO educatorDTO) throws Exception{
        if(educatorRepository.existsById(educ_id)){
//           Educator educator = (educatorRepository.findById(educ_id)).get();
           Optional<Educator> educator = (educatorRepository.findById(educ_id));
           educator.get().setFullNames(educatorDTO.getFullNames());
           educator.get().setUsername(educatorDTO.getUsername());
           educator.get().setEmail(educatorDTO.getEmail());
           educator.get().setNational_id(educatorDTO.getNational_id());
           educator.get().setPassword(educatorDTO.getPassword());
            return ResponseEntity.ok().body(new ApiResponse(
                    true,
                    "Updating of educator success",
                    educator.map(educatorDTOMapper).get()
            ));
        }else{
            return ResponseEntity.status(404).body(new ApiResponse(
                    false,
                    "The user with id: " + educ_id + " does not exist"
            ));
        }
    }
}
