package com.example.schedulingdemo.util;

public class ReminderNotAddedException extends RuntimeException{
    public ReminderNotAddedException(String msg) {
        super(msg);
    }
}
