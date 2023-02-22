package rw.iTrack.Application.v1.dto;

import lombok.Getter;
import lombok.Setter;
import rw.iTrack.Application.v1.enums.Gender;

@Getter
@Setter
public class CreateStudentDTO {

    private String names;
    private String email;
    private String password;
    private Gender gender;
    private int year;
    private String className;


}
