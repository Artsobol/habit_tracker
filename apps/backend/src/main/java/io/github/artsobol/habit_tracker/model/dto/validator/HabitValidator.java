package io.github.artsobol.habit_tracker.model.dto.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = HabitScheduleValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HabitValidator {
    String message() default "Field targetPerWeek must be filled";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
