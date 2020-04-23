package com.kay.concurrency.simpledateformat;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by kay on 2018/5/28.
 */
@Slf4j
public class Java8TimeUtil {

    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String format(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return localDateTime.format(df);
    }

    public static Date parse(String str) {
        LocalDateTime dateTime = LocalDateTime.parse(str, df);
        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        return date;
    }

    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        log.info("now :{}",nowDate);

        LocalTime nowTime = LocalTime.now();
        log.info("now :{}",nowTime);

        LocalDateTime dateTime = LocalDateTime.now();

        Instant timestamp = Instant.now();
        log.info(timestamp.toString());

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String landing = dateTime.format(format);
        log.info("date to str :{}",landing);

        LocalDateTime dateTime1 = LocalDateTime.of(2018, 5, 28, 14, 30, 12);
        LocalDateTime dateTime2=LocalDateTime.parse("2018-05-30 18:31:55",format);
        log.info("str to date :{}",dateTime2.toString());
    }
}