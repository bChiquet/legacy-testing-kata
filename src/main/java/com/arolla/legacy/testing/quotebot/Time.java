package com.arolla.legacy.testing.quotebot;

import java.util.Calendar;
import java.util.Date;

public class Time {
    public Time() {
    }

    long getTimePassed() {
        return currentTimestamp() - startTimestamp();
    }

    long startTimestamp() {
        return new Date(2000, Calendar.JANUARY, 1)
                .getTime();
    }

    long currentTimestamp() {
        return new Date().getTime();
    }
}