package org.example.jdk.jdk8.date;

import java.time.*;
import java.util.Arrays;

import static java.time.temporal.TemporalAdjusters.lastInMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

/**
 * @see <a href="https://lw900925.github.io/java/java8-newtime-api.html">Java8时间api</a>
 */
public class DiffYMD {

    public static void main(String[] args) {
//        YMD();
//        YMDhms();
        System.out.println(System.lineSeparator());
//        specialData();
    }

    private static void specialData() {
        LocalDate date = LocalDate.now();
        LocalDate date7 = date.with(nextOrSame(DayOfWeek.SUNDAY));      // 返回下一个距离当前时间最近的星期日
        System.out.println(date7);
        LocalDate date9 = date.with(lastInMonth(DayOfWeek.SATURDAY));   // 返回本月最后一个星期六
        System.out.println(date9);
    }

    private static void YMDhms() {
        LocalDateTime aDate = LocalDateTime.now();
        LocalDateTime sixtyDaysBehind = aDate.plusMinutes(60);
        Duration duration = Duration.between(aDate, sixtyDaysBehind);

        long days = duration.toDays();              // 这段时间的总天数
        long hours = duration.toHours();            // 这段时间的总小时数
        long minutes = duration.toMinutes();        // 这段时间的总分钟数
        long seconds = duration.getSeconds();       // 这段时间的总秒数
        long milliSeconds = duration.toMillis();    // 这段时间的总毫秒数
        long nanoSeconds = duration.toNanos();      // 这段时间的总纳秒数
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
