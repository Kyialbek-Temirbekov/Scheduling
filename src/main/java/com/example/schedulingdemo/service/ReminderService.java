package com.example.schedulingdemo.service;

import com.example.schedulingdemo.dto.enums.Day;
import com.example.schedulingdemo.models.Reminder;
import com.example.schedulingdemo.repository.ReminderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReminderService {
    private final ReminderRepository repository;
    @Transactional
    public Reminder add(Reminder reminder) {
        return repository.save(reminder);
    }
    @Transactional
    public List<Reminder> getAll() {
        return repository.findAll();
    }

    public List<Reminder> getActiveReminders() {
        return getAll().stream().filter(this::isActive).toList();
    }

    @Scheduled(cron = "0 7 18 * * *")
    public void remind() {
        System.out.println("REMINDER: ");
        List<Reminder> reminders = getAll().stream().filter(this::isActive).toList();
        reminders.forEach(System.out::println);
    }

    private boolean isActive(Reminder reminder) {
        LocalDate now = LocalDate.now();
        boolean isAfterOrEqual = reminder.getStartDate() != null && (now.isEqual(reminder.getStartDate()) || now.isAfter(reminder.getStartDate()));
        boolean isBeforeOrEqual = reminder.getEndDate() != null && (now.isEqual(reminder.getEndDate()) || now.isBefore(reminder.getEndDate()));
        boolean isDayOfWeek = reminder.getDays() != null && reminder.getDays().contains(Day.valueOf(now.getDayOfWeek().toString()));
        boolean isTargetDay = reminder.getSchedule() != null && reminder.getSchedule().contains(now);
        return (isAfterOrEqual && isBeforeOrEqual && isDayOfWeek) || isTargetDay;
    }
}
