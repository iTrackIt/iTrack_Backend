package rw.iTrack.Application.v1.dto;

import rw.iTrack.Application.v1.models.Educator;
import rw.iTrack.Application.v1.models.Student;

import java.time.LocalDate;

public record EventDTO(
        String reason,
        int marks,
        LocalDate time_Removed,
        Educator educator,
        Student student
) {
}
