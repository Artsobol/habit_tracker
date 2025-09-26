package io.github.artsobol.habit_tracker.model.dto.checkInDto;

import io.github.artsobol.habit_tracker.model.entity.Habit;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CheckInResponseDto (
        Long id,
        Habit habit,
        LocalDate date,
        Integer amount,
        String note,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){}
