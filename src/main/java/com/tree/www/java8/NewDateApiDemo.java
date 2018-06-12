package com.tree.www.java8;

import java.time.*;

/**
 * 新的时间日期api
 * <p>
 * Created by pysh on 2018/6/7.
 */
public class NewDateApiDemo {
    public static void main(String[] args) {
        localDemo();
        System.out.println("-------------------------");
        zoneDemo();
    }

    private static void zoneDemo() {
        // 使用默认时区 ZoneId.systemDefault()
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("当前日期时间:" + now);

        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Europe/Paris]");
        System.out.println("Europe/Paris date: " + date1);

        System.out.println("local date:" + date1.toLocalDateTime());

        ZoneId id = ZoneId.of("Europe/Paris");
        //ZoneId id = ZoneId.SHORT_IDS.get("ECT"); // 等价巴黎

        System.out.println("巴黎当前日期时间: " + ZonedDateTime.now(id));

        // 与安装jdk时设置的环境变量有关
        System.out.println("默认时区: " + ZoneId.systemDefault());
    }

    private static void localDemo() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前日期时间:" + now);

        System.out.println("当前日期:" + now.toLocalDate());
        System.out.println("当前日期:" + LocalDate.now());

        System.out.println("当前时间:" + now.toLocalTime());
        System.out.println("当前时间:" + LocalTime.now());

        System.out.println(now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth());

        LocalDateTime dateTime = LocalDateTime.of(2018, 6, 6, 17, 18, 22);
        System.out.println("日期时间:" + dateTime);

        LocalDate date1 = LocalDate.ofYearDay(2018, 178);
        System.out.println("日期1:" + date1);

        LocalDate date2 = LocalDate.of(2018, 6, 7);
        System.out.println("日期2：" + date2);

        LocalTime time = LocalTime.of(17, 22, 18);
        System.out.println("时间：" + time);
    }
}
