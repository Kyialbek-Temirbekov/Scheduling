package com.example.schedulingdemo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReminderErrorResponse {
    private String message;
    private long timestamp;
}
