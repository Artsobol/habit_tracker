package io.github.artsobol.habit_tracker.model.dto.mapping;

import io.github.artsobol.habit_tracker.model.dto.HabitCreateDto;
import io.github.artsobol.habit_tracker.model.dto.HabitResponseDto;
import io.github.artsobol.habit_tracker.model.entity.Habit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HabitMapper {
    Habit toEntity(HabitCreateDto habitCreateDto);
    HabitResponseDto toResponseDto(Habit habit);
}
