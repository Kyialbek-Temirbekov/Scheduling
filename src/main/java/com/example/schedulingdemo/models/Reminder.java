package com.example.schedulingdemo.models;

import com.example.schedulingdemo.dto.enums.Day;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "reminder")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "message", nullable = false, length = 300)
    private String message;

    private LocalDate startDate;

    private LocalDate endDate;

    @ElementCollection(targetClass = Day.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Day> days;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "habit_schedule", joinColumns = @JoinColumn(name = "habit_id"))
    private Set<LocalDate> schedule;
}