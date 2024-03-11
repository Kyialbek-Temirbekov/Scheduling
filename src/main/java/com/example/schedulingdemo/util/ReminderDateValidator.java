package com.example.schedulingdemo.util;

import com.example.schedulingdemo.dto.request.ReminderRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ReminderDateValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ReminderRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ReminderRequest reminder = (ReminderRequest) target;
        if(reminder.getStartDate() == null)
            return;
        if(reminder.getStartDate().isEqual(reminder.getEndDate()))
            errors.rejectValue("startDate", "", "Start Date cannot be equal to End Date");
        if(reminder.getStartDate().isAfter(reminder.getEndDate()))
            errors.rejectValue("startDate", "", "Start Date cannot be after End Date");
    }
}
