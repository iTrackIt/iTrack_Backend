package rw.iTrack.Application.v1.dto;

import lombok.Getter;
import lombok.Setter;
import rw.iTrack.Application.v1.enums.Gender;

@Getter
@Setter
public class UpdateStudentDTO {

    private String names;
    private String email;
    private Gender gender;
    private int year;
    private Character className;

}
