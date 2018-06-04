package com.tree.www.pattern.chains.chains2;

/**
 * 批准结果对象
 * <p>
 * Created by pysh on 2018/6/4.
 */
public class Result {
    private boolean isRatify;
    private String info;

    public Result(boolean isRatify, String info) {
        this.isRatify = isRatify;
        this.info = info;
    }

    public boolean isRatify() {
        return isRatify;
    }

    public void setRatify(boolean ratify) {
        isRatify = ratify;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Result{" +
                "isRatify=" + isRatify +
                ", info='" + info + '\'' +
                '}';
    }
}
