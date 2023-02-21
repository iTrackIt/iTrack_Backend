package rw.iTrack.Application.v1.dto;

import org.springframework.stereotype.Component;
import rw.iTrack.Application.v1.models.Educator;

import java.util.function.Function;

@Component
public class EducatorDTOMapper implements Function<Educator, EducatorDTO> {
    @Override
    public EducatorDTO apply(Educator educator) {
        return  new EducatorDTO(
                educator.getFullNames(),
                educator.getUsername(),
                educator.getEmail(),
                educator.getNational_id(),
                educator.getGender()
        );
    }
}
