package com.example.schedulingdemo.dto.response;

import com.example.schedulingdemo.dto.enums.Day;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReminderResponse {
    private long id;

    private String message;

    private LocalDate startDate;

    private LocalDate endDate;

    private Set<Day> days;

    private Set<LocalDate> schedule;
}
