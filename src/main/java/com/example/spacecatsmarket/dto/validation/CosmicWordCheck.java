package com.example.spacecatsmarket.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CosmicWordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CosmicWordCheck {
    String message() default "The name must contain cosmic terms like 'star', 'galaxy', or 'comet'.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}