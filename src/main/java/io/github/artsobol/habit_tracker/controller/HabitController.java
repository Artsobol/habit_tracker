package io.github.artsobol.habit_tracker.controller;

import io.github.artsobol.habit_tracker.model.dto.HabitCreateDto;
import io.github.artsobol.habit_tracker.model.dto.HabitResponseDto;
import io.github.artsobol.habit_tracker.model.dto.mapping.HabitMapper;
import io.github.artsobol.habit_tracker.model.entity.Habit;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.github.artsobol.habit_tracker.service.HabitService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habits")
public class HabitController {

    private final HabitService habitService;
    private final HabitMapper habitMapper;

    public HabitController(HabitService habitService, HabitMapper habitMapper) {
        this.habitService = habitService;
        this.habitMapper = habitMapper;
    }

    @GetMapping
    public ResponseEntity<List<Habit>> getHabits() {
        return ResponseEntity.status(HttpStatus.OK).body(habitService.getHabits());
    }

    @GetMapping("/{habitId}")
    public ResponseEntity<Habit> getHabitById(@PathVariable Long habitId) {
        return ResponseEntity.status(HttpStatus.OK).body(habitService.getHabitById(habitId));
    }

    @PostMapping
    public ResponseEntity<HabitResponseDto> createHabit(@RequestBody @Valid HabitCreateDto habitDto) {
        Habit saved = habitService.createHabit(habitDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(habitMapper.toResponseDto(saved));
    }

    @PostMapping("/{habitId}/archive")
    public ResponseEntity<Habit> archiveHabit(@PathVariable Long habitId) {
        return ResponseEntity.status(HttpStatus.OK).body(habitService.archiveHabit(habitId));
    }

    @PostMapping("/{habitId}/restore")
    public ResponseEntity<Habit> restoreHabit(@PathVariable Long habitId) {
        return ResponseEntity.status(HttpStatus.OK).body(habitService.restoreHabit(habitId));
    }

    @PatchMapping("/{habitId}")
    public ResponseEntity<Habit> updateHabit(@PathVariable Long habitId, @RequestBody Habit updatedHabit) {
        return ResponseEntity.status(HttpStatus.OK).body(habitService.updateHabit(habitId, updatedHabit));
    }

}
