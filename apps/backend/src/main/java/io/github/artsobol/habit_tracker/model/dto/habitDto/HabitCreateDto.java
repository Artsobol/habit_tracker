package io.github.artsobol.habit_tracker.model.dto.habitDto;

import io.github.artsobol.habit_tracker.model.dto.habitDto.validator.HabitValidator;
import io.github.artsobol.habit_tracker.model.enums.habit.DayOfWeek;
import io.github.artsobol.habit_tracker.model.enums.habit.HabitStatus;
import io.github.artsobol.habit_tracker.model.enums.habit.ScheduleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;

@HabitValidator
public record HabitCreateDto(
        @NotBlank String title,
        String description,
        @NotNull ScheduleType scheduleType,
        HabitStatus status,
        Set<DayOfWeek> daysOfWeek,
        Integer targetPerDay,
        Integer targetPerWeek,
        LocalDate startDate,
        LocalDate endDate
){
    public HabitCreateDto {
        if (targetPerDay == null) targetPerDay = 1;
    }
}

