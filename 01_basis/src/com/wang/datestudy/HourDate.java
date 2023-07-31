package com.wang.datestudy;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wyt
 * @date 2023/5/10 10:13
 * @description
 */
public class HourDate {

    @Test
    public void test1() {
        String format  = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime dateTime = LocalDateTime.parse("2023-05-10 00:00:00", dateTimeFormatter);
        LocalDateTime time = dateTime.plusHours(13);
        System.out.println(dateTime.getHour());
        System.out.println(time.getHour());
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("HH:mm");
        String format1 = time.format(hourFormat);
        System.out.println(time.format(dateTimeFormatter));
        System.out.println(format1);
    }

    @Test
    public void test2 () {
        System.out.println("2023-05-10 00:00:00".compareTo("2023-05-09 00:00:00"));
    }


}
