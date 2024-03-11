package com.example.schedulingdemo.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.util.Set;

public class EachFutureOrPresentValidator implements ConstraintValidator<EachFutureOrPresent, Set<LocalDate>> {
    @Override
    public boolean isValid(Set<LocalDate> dates, ConstraintValidatorContext context) {
        LocalDate now = LocalDate.now();
        return dates == null || dates.stream().allMatch(date -> date == null || date.isEqual(now) || date.isAfter(now));
    }
}
