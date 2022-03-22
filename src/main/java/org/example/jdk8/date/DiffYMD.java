package org.example.jdk8.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DiffYMD {

    public static void main(String[] args) {
        YMD();
//        hms();
    }

    private static void YMD() {
        LocalDate aDate = LocalDate.of(2020, 9, 11);
        LocalDate sixtyDaysBehind = aDate.minusDays(60);
        Period period = Period.between(aDate, sixtyDaysBehind);
        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());
        System.out.println(Arrays.toString(new int[]{years, months, days}));
    }
}
