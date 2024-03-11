package com.example.schedulingdemo.controller;

import com.example.schedulingdemo.dto.request.ReminderRequest;
import com.example.schedulingdemo.dto.response.ReminderErrorResponse;
import com.example.schedulingdemo.dto.response.ReminderListResponse;
import com.example.schedulingdemo.dto.response.ReminderResponse;
import com.example.schedulingdemo.models.Reminder;
import com.example.schedulingdemo.service.ReminderService;
import com.example.schedulingdemo.util.ErrorsUtil;
import com.example.schedulingdemo.util.ReminderDateValidator;
import com.example.schedulingdemo.util.ReminderNotAddedException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reminder")
@RequiredArgsConstructor
public class ReminderController implements ErrorsUtil {
    private final ReminderService reminderService;
    private final ModelMapper modelMapper;
    private final ReminderDateValidator reminderDateValidator;

    @PostMapping("/add")
    public ReminderResponse add(@RequestBody @Valid ReminderRequest reminderRequest,
                                BindingResult bindingResult) {
        reminderDateValidator.validate(reminderRequest, bindingResult);
        if(bindingResult.hasErrors()) {
            throw new ReminderNotAddedException(getErrors(bindingResult));
        }
        Reminder reminder = reminderService.add(converToReminder(reminderRequest));
        return convertToReminderResponse(reminder);
    }

    @GetMapping("/get-all")
    public ReminderListResponse getAll() {
        return new ReminderListResponse(reminderService.getAll().stream()
                .map(this::convertToReminderResponse).toList());
    }

    @GetMapping("/get-active")
    public ReminderListResponse getActive() {
        return new ReminderListResponse(reminderService.getActiveReminders().stream()
                .map(this::convertToReminderResponse).toList());
    }

    @ExceptionHandler
    private ResponseEntity<ReminderErrorResponse> handleException(ReminderNotAddedException e) {
        ReminderErrorResponse response = new ReminderErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Reminder converToReminder(ReminderRequest reminderRequest) {
        return modelMapper.map(reminderRequest, Reminder.class);
    }

    private ReminderResponse convertToReminderResponse(Reminder reminder) {
        return modelMapper.map(reminder, ReminderResponse.class);
    }
}
