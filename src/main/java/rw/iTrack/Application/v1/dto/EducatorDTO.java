package rw.iTrack.Application.v1.dto;

import rw.iTrack.Application.v1.enums.Gender;

import java.util.UUID;

public record EducatorDTO(
        UUID id,
        String fullName,
        String username,
        String email,
        String national_id,
        Gender gender
        ) {
}
