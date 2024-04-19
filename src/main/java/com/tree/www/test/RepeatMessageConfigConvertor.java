package com.tree.www.test;

import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pysh on 2021/4/23.
 */
public class RepeatMessageConfigConvertor {

  public static LocalDate pasreDate(String s, String pattern) {
    return LocalDate.parse(s, DateTimeFormatter.ofPattern(pattern));
  }

  public static LocalTime parseTime(String s, String pattern) {
    return LocalTime.parse(s, DateTimeFormatter.ofPattern(pattern));
  }

  public static List<LocalDateTime> getPushTimeList(RepeatPushConfig config) {
    List<LocalDateTime> list = Lists.newArrayList();
    LocalDate pushDateStart = pasreDate(config.getPushDateStart(), "yyyy/MM/dd");
    LocalDate pushDateEnd = pasreDate(config.getPushDateEnd(), "yyyy/MM/dd");
    List<LocalTime> localTimes = config.getTimeConfig().stream()
        .map(s -> parseTime(s, "HH:mm"))
        .collect(Collectors.toList());

    do {
      boolean inRange = false;
      if (config.getCycleType() == 0) {
        inRange = true;
      }
      if (config.getCycleType() == 1) {
        inRange = config.getCycleConfig().contains(pushDateStart.getDayOfWeek().getValue() % 7);
      }
      if (config.getCycleType() == 2) {
        inRange = config.getCycleConfig().contains(pushDateStart.getDayOfMonth())
            || (config.getCycleConfig().contains(0) && pushDateStart.lengthOfMonth() == pushDateStart.getDayOfMonth());
      }
      if (inRange) {
        for (LocalTime time : localTimes) {
          LocalDateTime localDateTime = LocalDateTime.of(pushDateStart, time);
          if (localDateTime.isAfter(LocalDateTime.now())) {
            list.add(LocalDateTime.of(pushDateStart, time));
          }
        }
      }
      pushDateStart = pushDateStart.plusDays(1);
    } while (!pushDateStart.isAfter(pushDateEnd));

    return list;
  }

  public static void main(String[] args) {
    //RepeatPushConfig config = new RepeatPushConfig();
    //config.setCycleType(2);
    //config.setCycleConfig(Lists.newArrayList(0, 1, 2, 6));
    //config.setTimeConfig(Lists.newArrayList("12:30", "11:20", "17:30"));
    //config.setPushDateStart("2021/04/25");
    //config.setPushDateEnd("2021/06/22");
    //List<LocalDateTime> list = getPushTimeList(config);
    //System.out.println(list);
    System.out.println(test(Lists.newArrayList("2021/11/11 00:01", "2021/11/11 00:08", "2021/11/11 23:55",
        "2021/11/12 00:01", "2021/11/12 13:02", "2021/11/12 23:55")));
  }

  public static String test(List<String> timeConfigs) {
    List<LocalDateTime> localTimes = timeConfigs.stream()
        .map(s -> LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")))
        .sorted()
        .collect(Collectors.toList());
    for (int i = 1; i < localTimes.size(); i++) {
      if(toMillionTime(localTimes.get(i)) - toMillionTime(localTimes.get(i-1)) < 5*60*1000) {
        return "ERROR";
      }
    }
    return "SUCC";
  }

  public static long toMillionTime(LocalDateTime localDateTime){
    return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
  }

  static class RepeatPushConfig {
    // 周期类型;0-每日,1-每周,2-每月
    private Integer cycleType;

    // 周期配置;每周[0-6] 0:周日,1-6周一到周六;每月[0-31] 0:每月最后一日;
    private List<Integer> cycleConfig;

    // 时间配置 HH:mm:00
    private List<String> timeConfig;

    // 推送日期范围 yyyy/MM/dd
    private String pushDateStart;
    private String pushDateEnd;

    public void setCycleType(Integer cycleType) {
      this.cycleType = cycleType;
    }

    public void setCycleConfig(List<Integer> cycleConfig) {
      this.cycleConfig = cycleConfig;
    }

    public void setTimeConfig(List<String> timeConfig) {
      this.timeConfig = timeConfig;
    }

    public void setPushDateStart(String pushDateStart) {
      this.pushDateStart = pushDateStart;
    }

    public void setPushDateEnd(String pushDateEnd) {
      this.pushDateEnd = pushDateEnd;
    }

    public Integer getCycleType() {
      return cycleType;
    }

    public List<Integer> getCycleConfig() {
      return cycleConfig;
    }

    public List<String> getTimeConfig() {
      return timeConfig;
    }

    public String getPushDateStart() {
      return pushDateStart;
    }

    public String getPushDateEnd() {
      return pushDateEnd;
    }
  }
}
