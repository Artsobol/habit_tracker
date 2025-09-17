package service.impl;

import model.entity.Habit;
import model.enums.habit.HabitStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.HabitRepository;
import service.HabitService;

import java.util.List;

@Service
@Transactional
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;

    public HabitServiceImpl(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> getHabits() {
        return habitRepository.findAll();
    }

    public Habit getHabitById(Long id) {
        return habitRepository.findById(id).orElse(null);
    }

    // TODO: Refactor this method to DTO
    @Override
    public Habit updateHabit(Long id, Habit updatedHabit) {
        Habit habit = getHabitById(id);
        if (updatedHabit.getTitle() != null) {
            habit.setTitle(updatedHabit.getTitle());
        }
        if (updatedHabit.getDescription() != null) {
            habit.setDescription(updatedHabit.getDescription());
        }
        if (updatedHabit.getStatus() != null) {
            habit.setStatus(updatedHabit.getStatus());
        }
        if (updatedHabit.getScheduleType() != null) {
            habit.setScheduleType(updatedHabit.getScheduleType());
        }
        if (updatedHabit.getDaysOfWeek() != null) {
            habit.setDaysOfWeek(updatedHabit.getDaysOfWeek());
        }
        if (updatedHabit.getTargetPerDay() != null) {
            habit.setTargetPerDay(updatedHabit.getTargetPerDay());
        }
        if (updatedHabit.getTargetPerWeek() != null) {
            habit.setTargetPerWeek(updatedHabit.getTargetPerWeek());
        }
        if (updatedHabit.getStartDate() != null) {
            habit.setStartDate(updatedHabit.getStartDate());
        }
        if (updatedHabit.getEndDate() != null) {
            habit.setEndDate(updatedHabit.getEndDate());
        }
        return habitRepository.save(habit);
    }

    @Override
    public Habit archiveHabit(Long id) {
        Habit habit = getHabitById(id);
        habit.setStatus(HabitStatus.ARCHIVE);
        return habitRepository.save(habit);
    }

    @Override
    public Habit restoreHabit(Long id) {
        Habit habit = getHabitById(id);
        habit.setStatus(HabitStatus.ACTIVE);
        return habitRepository.save(habit);
    }

    public Habit createHabit(Habit habit) {
        return habitRepository.save(habit);
    }

}
