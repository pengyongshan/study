package com.tree.www.rule;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.util.List;

/**
 * 规则配置
 *
 * Created by pysh on 2017/12/6.
 */
public class RuleLimitConfig {
    Limit<BigDecimal> amount;
    List<Integer> appIds;
    Limit<Integer> age;
    Limit<Double> downRate;
    List<Integer> notBankIds;
    List<Integer> notChannels;
    PushDateLimit pushDate;
    List<Limit<String>> pushTimes;
    List<String> notRePushFailType;
    List<Integer> stages;
    boolean needRiskWash;
    List<String> bsCreditComments;

    public static void main(String[] args) {
        RuleLimitConfig config = new RuleLimitConfig();
        config.setAmount(new Limit<>(new BigDecimal(1000), new BigDecimal(10000)));
        config.setAppIds(ImmutableList.of(1,6));
        config.setAge(new Limit<>(22, 45));
        config.setDownRate(new Limit<>(0.035, 0.067));
        config.setNotBankIds(ImmutableList.of(6, 13));
        config.setNotChannels(ImmutableList.of(40031,40035));
        config.setPushDate(new PushDateLimit(true, true, ImmutableList.of("Mon","Tue","WED")));
        config.setPushTimes(ImmutableList.of(new Limit<>("0930", "1130"), new Limit<>("1300", "1500")));
        config.setNotRePushFailType(ImmutableList.of("AUDIT_FAIL"));
        config.setStages(ImmutableList.of(6, 12));
        config.setNeedRiskWash(true);
        config.setBsCreditComments(ImmutableList.of("A", "B", "C", "DQD"));
        System.out.println(JSON.toJSONString(config));
    }

    public Limit<BigDecimal> getAmount() {
        return amount;
    }

    public void setAmount(Limit<BigDecimal> amount) {
        this.amount = amount;
    }

    public List<Integer> getAppIds() {
        return appIds;
    }

    public void setAppIds(List<Integer> appIds) {
        this.appIds = appIds;
    }

    public Limit<Integer> getAge() {
        return age;
    }

    public void setAge(Limit<Integer> age) {
        this.age = age;
    }

    public Limit<Double> getDownRate() {
        return downRate;
    }

    public void setDownRate(Limit<Double> downRate) {
        this.downRate = downRate;
    }

    public List<Integer> getNotBankIds() {
        return notBankIds;
    }

    public void setNotBankIds(List<Integer> notBankIds) {
        this.notBankIds = notBankIds;
    }

    public List<Integer> getNotChannels() {
        return notChannels;
    }

    public void setNotChannels(List<Integer> notChannels) {
        this.notChannels = notChannels;
    }

    public PushDateLimit getPushDate() {
        return pushDate;
    }

    public void setPushDate(PushDateLimit pushDate) {
        this.pushDate = pushDate;
    }

    public List<Limit<String>> getPushTimes() {
        return pushTimes;
    }

    public void setPushTimes(List<Limit<String>> pushTimes) {
        this.pushTimes = pushTimes;
    }

    public List<String> getNotRePushFailType() {
        return notRePushFailType;
    }

    public void setNotRePushFailType(List<String> notRePushFailType) {
        this.notRePushFailType = notRePushFailType;
    }

    public List<Integer> getStages() {
        return stages;
    }

    public void setStages(List<Integer> stages) {
        this.stages = stages;
    }

    public boolean isNeedRiskWash() {
        return needRiskWash;
    }

    public void setNeedRiskWash(boolean needRiskWash) {
        this.needRiskWash = needRiskWash;
    }

    public List<String> getBsCreditComments() {
        return bsCreditComments;
    }

    public void setBsCreditComments(List<String> bsCreditComments) {
        this.bsCreditComments = bsCreditComments;
    }
}

class Limit<T extends Comparable<T>> {
    T low;
    T top;

    public Limit(T low, T top) {
        this.low = low;
        this.top = top;
    }

    public T getLow() {
        return low;
    }

    public void setLow(T low) {
        this.low = low;
    }

    public T getTop() {
        return top;
    }

    public void setTop(T top) {
        this.top = top;
    }
}

class PushDateLimit {
    boolean onlyWorkDay;
    boolean needChecked;
    List<String> checkeds;

    public PushDateLimit(boolean onlyWorkDay, boolean needChecked, List<String> checkeds) {
        this.onlyWorkDay = onlyWorkDay;
        this.needChecked = needChecked;
        this.checkeds = checkeds;
    }

    public boolean isOnlyWorkDay() {
        return onlyWorkDay;
    }

    public void setOnlyWorkDay(boolean onlyWorkDay) {
        this.onlyWorkDay = onlyWorkDay;
    }

    public boolean isNeedChecked() {
        return needChecked;
    }

    public void setNeedChecked(boolean needChecked) {
        this.needChecked = needChecked;
    }

    public List<String> getCheckeds() {
        return checkeds;
    }

    public void setCheckeds(List<String> checkeds) {
        this.checkeds = checkeds;
    }
}
