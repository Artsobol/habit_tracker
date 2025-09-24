package io.github.artsobol.habit_tracker.service.impl;

import io.github.artsobol.habit_tracker.exception.HabitNotFoundException;
import io.github.artsobol.habit_tracker.model.dto.HabitCreateDto;
import io.github.artsobol.habit_tracker.model.dto.HabitPatchDto;
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

    @Override
    public Habit updateHabit(Long id, HabitPatchDto habitPatchDto) {
        Habit habit = getHabitById(id);
        habitMapper.updateFromPatch(habitPatchDto, habit);
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
