package io.github.artsobol.habit_tracker.model.dto.habitDto.mapping;

import io.github.artsobol.habit_tracker.model.dto.checkInDto.CheckInCreateDto;
import io.github.artsobol.habit_tracker.model.dto.checkInDto.CheckInPatchDto;
import io.github.artsobol.habit_tracker.model.dto.checkInDto.CheckInResponseDto;
import io.github.artsobol.habit_tracker.model.entity.CheckIn;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CheckInMapper {
    CheckIn toEntity(CheckInCreateDto checkInCreateDto);
    CheckInResponseDto toResponseDto(CheckIn checkIn);
    void updateFromPatch(CheckInPatchDto checkInPatchDto, @MappingTarget CheckIn checkIn);
}
