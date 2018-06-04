package com.tree.www.pattern.chains.chains2;

/**
 * 请假对象
 *
 * Created by pysh on 2018/6/4.
 */
public class Request {
    private String name;
    private int days;
    private String reason;
    private String groupLeaderInfo;
    private String managerInfo;
    private String departmentHeaderInfo;
    private String customInfo;

    public Request(Builder builder) {
        this.name = builder.name;
        this.reason = builder.reason;
        this.days = builder.days;
        this.groupLeaderInfo = builder.groupLeaderInfo;
        this.managerInfo = builder.managerInfo;
        this.departmentHeaderInfo = builder.departmentHeaderInfo;
        this.customInfo = builder.customInfo;
    }

    public static class Builder {
        private String name;
        private int days;
        private String reason;
        private String groupLeaderInfo;
        private String managerInfo;
        private String departmentHeaderInfo;
        private String customInfo;

        public Builder newRequest(Request request) {
            this.name = request.name;
            this.days = request.days;
            this.reason = request.reason;
            if (request.groupLeaderInfo != null
                    && !request.groupLeaderInfo.equals("")) {
                this.groupLeaderInfo = request.groupLeaderInfo;
            }

            if (request.managerInfo != null && !request.managerInfo.equals("")) {
                this.managerInfo = request.managerInfo;
            }

            if (request.departmentHeaderInfo != null
                    && !request.departmentHeaderInfo.equals("")) {
                this.departmentHeaderInfo = request.departmentHeaderInfo;
            }

            if (request.customInfo != null && !request.customInfo.equals("")) {
                this.customInfo = request.customInfo;
            }
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDays(int days) {
            this.days = days;
            return this;
        }

        public Builder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder setGroupLeaderInfo(String groupLeaderInfo) {
            this.groupLeaderInfo = groupLeaderInfo;
            return this;
        }

        public Builder setManagerInfo(String managerInfo) {
            this.managerInfo = managerInfo;
            return this;
        }

        public Builder setDepartmentHeaderInfo(String departmentHeaderInfo) {
            this.departmentHeaderInfo = departmentHeaderInfo;
            return this;
        }

        public Builder setCustomInfo(String customInfo) {
            this.customInfo = customInfo;
            return this;
        }
    }

    public String getName() {
        return name;
    }

    public String getReason() {
        return reason;
    }

    public int getDays() {
        return days;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getGroupLeaderInfo() {
        return groupLeaderInfo;
    }

    public void setGroupLeaderInfo(String groupLeaderInfo) {
        this.groupLeaderInfo = groupLeaderInfo;
    }

    public String getManagerInfo() {
        return managerInfo;
    }

    public void setManagerInfo(String managerInfo) {
        this.managerInfo = managerInfo;
    }

    public String getDepartmentHeaderInfo() {
        return departmentHeaderInfo;
    }

    public void setDepartmentHeaderInfo(String departmentHeaderInfo) {
        this.departmentHeaderInfo = departmentHeaderInfo;
    }

    public String getCustomInfo() {
        return customInfo;
    }

    public void setCustomInfo(String customInfo) {
        this.customInfo = customInfo;
    }

    @Override
    public String toString() {
        return "Request [name=" + name + ", reason=" + reason + ", days="
                + days + ",customInfo=" + customInfo + ", groupLeaderInfo="
                + groupLeaderInfo + ", managerInfo=" + managerInfo
                + ", departmentHeaderInfo=" + departmentHeaderInfo + "]";
    }
}
