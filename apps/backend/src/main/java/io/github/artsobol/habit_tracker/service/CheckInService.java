package io.github.artsobol.habit_tracker.service;

import io.github.artsobol.habit_tracker.model.dto.checkInDto.CheckInCreateDto;
import io.github.artsobol.habit_tracker.model.dto.checkInDto.CheckInPatchDto;
import io.github.artsobol.habit_tracker.model.dto.checkInDto.CheckInResponseDto;
import io.github.artsobol.habit_tracker.model.dto.habitDto.HabitResponseDto;
import io.github.artsobol.habit_tracker.model.entity.CheckIn;

import java.time.LocalDate;
import java.util.List;

public interface CheckInService {
    CheckInResponseDto createCheckIn(Long habitId, CheckInCreateDto checkInCreateDto);
    List<CheckInResponseDto> getCheckInsByPeriod(Long habitId, LocalDate startDate, LocalDate endDate);
    CheckInResponseDto getCheckInByHabitIdAndDate(Long habitId, LocalDate date);
    CheckInResponseDto updateCheckIn(Long id, LocalDate date, CheckInPatchDto checkInPatchDto);
    void deleteCheckIn(Long habitId, LocalDate date);
}
