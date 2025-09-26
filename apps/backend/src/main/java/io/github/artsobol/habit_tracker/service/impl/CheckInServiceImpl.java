package io.github.artsobol.habit_tracker.service.impl;

import io.github.artsobol.habit_tracker.exception.CheckInNotFoundException;
import io.github.artsobol.habit_tracker.model.dto.checkInDto.CheckInCreateDto;
import io.github.artsobol.habit_tracker.model.dto.checkInDto.CheckInPatchDto;
import io.github.artsobol.habit_tracker.model.dto.checkInDto.CheckInResponseDto;
import io.github.artsobol.habit_tracker.model.dto.habitDto.mapping.CheckInMapper;
import io.github.artsobol.habit_tracker.model.entity.CheckIn;
import io.github.artsobol.habit_tracker.model.entity.Habit;
import io.github.artsobol.habit_tracker.repository.CheckInRepository;
import io.github.artsobol.habit_tracker.service.CheckInService;
import io.github.artsobol.habit_tracker.service.HabitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CheckInServiceImpl implements CheckInService {

    private final CheckInRepository checkInRepository;
    private final CheckInMapper checkInMapper;
    private final HabitService habitService;

    public CheckInServiceImpl(CheckInRepository checkInRepository, CheckInMapper checkInMapper, HabitService habitService) {
        this.checkInRepository = checkInRepository;
        this.checkInMapper = checkInMapper;
        this.habitService = habitService;
    }

    @Override
    public CheckInResponseDto createCheckIn(Long habitId, CheckInCreateDto checkInCreateDto) {
        CheckIn checkIn = checkInMapper.toEntity(checkInCreateDto);
        Habit habit = habitService.getHabitById(habitId);
        habit.setId(habitId);
        checkIn.setHabit(habit);
        checkInRepository.save(checkIn);
        return checkInMapper.toResponseDto(checkIn);
    }

    @Override
    public List<CheckInResponseDto> getCheckInsByPeriod(Long habitId, LocalDate startDate, LocalDate endDate) {
        List<CheckInResponseDto> checkIns = new ArrayList<>();
        checkInRepository.findByHabitIdAndDateBetweenAndIsDeletedFalse(habitId, startDate, endDate).forEach(checkIn -> checkIns.add(checkInMapper.toResponseDto(checkIn)));
        return checkIns;
    }

    @Override
    public CheckInResponseDto getCheckInByHabitIdAndDate(Long habitId, LocalDate date) {
        CheckIn checkIn = getCheckInt(habitId, date);
        return checkInMapper.toResponseDto(checkIn);
    }

    @Override
    public CheckInResponseDto updateCheckIn(Long habitId, LocalDate date, CheckInPatchDto checkInPatchDto) {
        CheckIn checkIn = getCheckInt(habitId, date);
        checkInMapper.updateFromPatch(checkInPatchDto, checkIn);
        return checkInMapper.toResponseDto(checkInRepository.save(checkIn));
    }

    @Override
    public void deleteCheckIn(Long habitId, LocalDate date) {
        CheckIn checkIn = getCheckInt(habitId, date);
        checkIn.setDeleted(true);
        checkInRepository.save(checkIn);
    }

    private CheckIn getCheckInt(Long id, LocalDate date) {
        return checkInRepository.findByHabitIdAndDateAndIsDeletedFalse(id, date).orElseThrow(() -> new CheckInNotFoundException(id, date));
    }
}
