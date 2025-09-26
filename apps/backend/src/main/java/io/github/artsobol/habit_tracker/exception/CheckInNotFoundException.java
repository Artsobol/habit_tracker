package io.github.artsobol.habit_tracker.exception;

import java.time.LocalDate;

public class CheckInNotFoundException extends RuntimeException {
    public CheckInNotFoundException(Long habitId, LocalDate date) {
        super("Habit with habit id " + habitId + " and date " + date + " not found");
    }
}
