package io.github.artsobol.habit_tracker.model.dto;

import io.github.artsobol.habit_tracker.model.enums.habit.DayOfWeek;
import io.github.artsobol.habit_tracker.model.enums.habit.ScheduleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;

public record HabitCreateDto(
        @NotBlank String title,
        String description,
        @NotNull ScheduleType scheduleType,
        Set<DayOfWeek> daysOfWeek,
        Integer targetPerDay,
        Integer targetPerWeek,
        LocalDate startDate,
        LocalDate endDate
){}

