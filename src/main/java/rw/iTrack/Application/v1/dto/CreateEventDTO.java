package rw.iTrack.Application.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rw.iTrack.Application.v1.models.Educator;
import rw.iTrack.Application.v1.models.Student;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEventDTO {
    private String reason;
    private int marks;
    private LocalDate timeRemoved;
    private Educator educator;
    private Student student;

}
