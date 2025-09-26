package io.github.artsobol.habit_tracker.model.dto.checkInDto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CheckInCreateDto (
    @NotNull LocalDate date,
    @NotNull Integer amount,
    String note
) {}
