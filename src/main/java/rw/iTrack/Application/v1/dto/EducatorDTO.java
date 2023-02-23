package rw.iTrack.Application.v1.dto;

import rw.iTrack.Application.v1.enums.Gender;


public record EducatorDTO(
        Long id,
        String fullName,
        String username,
        String email,
        String national_id,
        Gender gender
        ) {
}
