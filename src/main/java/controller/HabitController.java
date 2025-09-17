package controller;

import model.entity.Habit;
import org.springframework.web.bind.annotation.*;
import service.HabitService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public List<Habit> getHabits() {
        return habitService.getHabits();
    }

    @GetMapping("/{habitId}")
    public Habit getHabitById(@PathVariable Long habitId) {
        return habitService.getHabitById(habitId);
    }

    @PostMapping
    public Habit createHabit(Habit habit) {
        return habitService.createHabit(habit);
    }

    @PostMapping("/{habitId}/archive")
    public Habit archiveHabit(@PathVariable Long habitId) {
        return habitService.archiveHabit(habitId);
    }

    @PostMapping("/{habitId}/restore")
    public Habit restoreHabit(@PathVariable Long habitId) {
        return habitService.restoreHabit(habitId);
    }

    @PatchMapping("/{habitId}")
    public Habit updateHabit(@PathVariable Long habitId, @RequestBody Habit updatedHabit) {
        return habitService.updateHabit(habitId, updatedHabit);
    }


}
