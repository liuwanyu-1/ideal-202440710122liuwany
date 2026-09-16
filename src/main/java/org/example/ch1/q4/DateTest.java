package org.example.ch1.q4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;

public class DateTest {
    public static void main(String[] args) {
        // JDK6 版本
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 100);
        Date date6 = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 EEEE");
        String result6 = sdf.format(date6);
        System.out.println("JDK6：" + result6);

        // JDK8 版本
        LocalDate today8 = LocalDate.now();
        LocalDate after100 = today8.plusDays(100);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 EEEE");
        String result8 = after100.format(dtf);
        System.out.println("JDK8：" + result8);
    }
}
