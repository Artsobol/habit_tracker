package io.github.artsobol.habit_tracker.service.impl;

import io.github.artsobol.habit_tracker.exception.HabitNotFoundException;
import io.github.artsobol.habit_tracker.model.dto.HabitCreateDto;
import io.github.artsobol.habit_tracker.model.dto.mapping.HabitMapper;
import io.github.artsobol.habit_tracker.model.entity.Habit;
import io.github.artsobol.habit_tracker.model.enums.habit.HabitStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.artsobol.habit_tracker.repository.HabitRepository;
import io.github.artsobol.habit_tracker.service.HabitService;

import java.util.List;

@Service
@Transactional
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;
    private final HabitMapper habitMapper;

    public HabitServiceImpl(HabitRepository habitRepository, HabitMapper habitMapper) {
        this.habitRepository = habitRepository;
        this.habitMapper = habitMapper;
    }

    public Habit createHabit(HabitCreateDto habit) {
        Habit entity = habitMapper.toEntity(habit);
        return habitRepository.save(entity);
    }

    public List<Habit> getHabits() {
        return habitRepository.findAll();
    }

    public Habit getHabitById(Long id) {
        return habitRepository.findById(id).orElseThrow(() -> new HabitNotFoundException(id));
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
        return changeStatusHabit(id, HabitStatus.ARCHIVE);
    }

    @Override
    public Habit restoreHabit(Long id) {
        return changeStatusHabit(id, HabitStatus.ACTIVE);
    }

    protected Habit changeStatusHabit(Long id, HabitStatus status) {
        Habit habit = getHabitById(id);
        habit.setStatus(status);
        return habitRepository.save(habit);
    }
}
