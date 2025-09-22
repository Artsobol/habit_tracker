package io.github.artsobol.habit_tracker.service;

import io.github.artsobol.habit_tracker.model.dto.HabitCreateDto;
import io.github.artsobol.habit_tracker.model.dto.HabitPatchDto;
import io.github.artsobol.habit_tracker.model.entity.Habit;

import java.util.List;

public interface HabitService {
    Habit createHabit(HabitCreateDto habitCreateDto);
    List<Habit> getHabits();
    Habit getHabitById(Long id);
    Habit updateHabit(Long id, HabitPatchDto habitPatchDto);
    Habit archiveHabit(Long id);
    Habit restoreHabit(Long id);
}
