package rw.iTrack.Application.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import rw.iTrack.Application.v1.enums.Gender;

@Getter
@Setter
@AllArgsConstructor
public class CreateEducatorDTO {
    private String fullNames;
    private String username;
    private String email;
    private String national_id;
    private Gender gender;
    private String password;

}
