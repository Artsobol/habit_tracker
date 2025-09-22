package io.github.artsobol.habit_tracker.model.dto.validator;

import io.github.artsobol.habit_tracker.model.dto.HabitCreateDto;
import io.github.artsobol.habit_tracker.model.enums.habit.ScheduleType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HabitScheduleValidator implements ConstraintValidator<HabitValidator, HabitCreateDto>  {

    @Override
    public boolean isValid(HabitCreateDto habitCreateDto, ConstraintValidatorContext constraintValidatorContext) {
        if (habitCreateDto == null) return true;
        constraintValidatorContext.disableDefaultConstraintViolation();
        ScheduleType type = habitCreateDto.scheduleType();
        boolean isValid = true;

        if (type == ScheduleType.DAILY) {
            if (!habitCreateDto.daysOfWeek().isEmpty() || habitCreateDto.targetPerWeek() != null) {
                addViolation(constraintValidatorContext, "daysOfWeek", "Schedule type is daily, but daysOfWeek is not empty or targetPerWeek is not null");
                isValid = false;
            }
        } else if (type == ScheduleType.DAYS_OF_WEEK) {
            if (habitCreateDto.daysOfWeek() == null || habitCreateDto.targetPerWeek() != null) {
                addViolation(constraintValidatorContext, "targetPerWeek", "Schedule type is daysOfWeek, but targetPerWeek is not null or daysOfWeek is empty");
                isValid = false;
            }
        } else if (type == ScheduleType.N_PER_WEEK) {
            if (habitCreateDto.daysOfWeek() != null || habitCreateDto.targetPerWeek() == null) {
                addViolation(constraintValidatorContext, "targetPerWeek", "Schedule type is nPerWeek, but targetPerWeek is null or daysOfWeek is not empty");
                isValid = false;
            }
        }
        return isValid;
    }

    private void addViolation(ConstraintValidatorContext context, String field, String message) {
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(field)
                .addConstraintViolation();
    }
}