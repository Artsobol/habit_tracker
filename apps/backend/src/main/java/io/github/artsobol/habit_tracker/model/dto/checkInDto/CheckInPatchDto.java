package io.github.artsobol.habit_tracker.model.dto.checkInDto;

import java.time.LocalDate;

public record CheckInPatchDto(
        LocalDate date,
        Integer amount,
        String note
) {
}
