package service;

import model.entity.Habit;

import java.util.List;

public interface HabitService {
    Habit createHabit(Habit habit);
    List<Habit> getHabits();
    Habit getHabitById(Long id);
    Habit updateHabit(Long id, Habit updatedHabit);
    Habit archiveHabit(Long id);
    Habit restoreHabit(Long id);
}
