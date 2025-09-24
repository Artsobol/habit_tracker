package io.github.artsobol.habit_tracker.repository;

import io.github.artsobol.habit_tracker.model.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {
}
