package com.example.schedulingdemo.dto.request;

import com.example.schedulingdemo.dto.enums.Day;
import com.example.schedulingdemo.util.EachFutureOrPresent;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ReminderRequest {
    @NotNull(message = "Message should not be null")
    @NotEmpty(message = "Message should not be empty")
    @Size(max = 300)
    private String message;
    @FutureOrPresent(message = "Invalid date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @FutureOrPresent(message = "Invalid date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @Size(max = 7)
    private Set<Day> days;
    @EachFutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Set<LocalDate> schedule;
}
