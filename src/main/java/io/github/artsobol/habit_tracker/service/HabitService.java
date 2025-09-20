package io.github.artsobol.habit_tracker.service;

import io.github.artsobol.habit_tracker.model.dto.HabitCreateDto;
import io.github.artsobol.habit_tracker.model.entity.Habit;

import java.util.List;

public interface HabitService {
    Habit createHabit(HabitCreateDto habit);
    List<Habit> getHabits();
    Habit getHabitById(Long id);
    Habit updateHabit(Long id, Habit updatedHabit);
    Habit archiveHabit(Long id);
    Habit restoreHabit(Long id);
}
