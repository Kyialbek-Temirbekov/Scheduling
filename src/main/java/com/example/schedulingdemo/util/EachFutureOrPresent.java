package com.example.schedulingdemo.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EachFutureOrPresentValidator.class)
public @interface EachFutureOrPresent {
    String message() default "Date should be future or present";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
