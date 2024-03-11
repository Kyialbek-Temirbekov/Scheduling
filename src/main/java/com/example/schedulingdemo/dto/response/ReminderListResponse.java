package com.example.schedulingdemo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ReminderListResponse {
    private List<ReminderResponse> reminders;
}
