package io.github.artsobol.habit_tracker.model.dto.habitDto;

import io.github.artsobol.habit_tracker.model.enums.habit.DayOfWeek;
import io.github.artsobol.habit_tracker.model.enums.habit.ScheduleType;

import java.time.LocalDate;
import java.util.Set;

public record HabitPatchDto (
        String title,
        String description,
        ScheduleType scheduleType,
        Set<DayOfWeek>daysOfWeek,
        Integer targetPerDay,
        Integer targetPerWeek,
        LocalDate startDate,
        LocalDate endDate
) {}

