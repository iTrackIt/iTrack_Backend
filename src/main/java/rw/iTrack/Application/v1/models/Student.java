package rw.iTrack.Application.v1.models;

import com.sun.tools.javac.jvm.Gen;
import lombok.*;
import rw.iTrack.Application.v1.enums.Gender;

import java.util.UUID;

@Entit
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    private UUID id;
    private String names;
    private String email;
    private int year;
    private Character className;
    private int marks;
    private String password;
    private Gender gender;

    public Student(String names, String email, String password, Gender gender) {
        this.names = names;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }


}
