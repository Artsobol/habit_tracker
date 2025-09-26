package io.github.artsobol.habit_tracker.model.dto.habitDto.mapping;

import io.github.artsobol.habit_tracker.model.dto.habitDto.HabitCreateDto;
import io.github.artsobol.habit_tracker.model.dto.habitDto.HabitPatchDto;
import io.github.artsobol.habit_tracker.model.dto.habitDto.HabitResponseDto;
import io.github.artsobol.habit_tracker.model.entity.Habit;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HabitMapper {
    Habit toEntity(HabitCreateDto habitCreateDto);
    HabitResponseDto toResponseDto(Habit habit);
    void updateFromPatch(HabitPatchDto habitPatchDto, @MappingTarget Habit habit);
}
