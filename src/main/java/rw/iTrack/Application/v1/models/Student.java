package rw.iTrack.Application.v1.models;

import com.sun.istack.NotNull;
import lombok.*;
import rw.iTrack.Application.v1.enums.Gender;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String names;

    @NotNull
    private String email;

    @NotNull
    private int year;

    @NotNull
    private String className;

    @Column()
    private int marks = 0;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Student(String names, String email, String password, Gender gender, String className, int year) {
        this.names = names;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.className = className;
        this.year = year;
    }


}
