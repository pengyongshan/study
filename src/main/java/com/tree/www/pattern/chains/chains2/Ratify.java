package com.tree.www.pattern.chains.chains2;

import java.util.List;

/**
 * 处理请求
 * <p>
 * Created by pysh on 2018/6/4.
 */
public interface Ratify {

    Result deal(Chain chain);

    // 对request和result封装，转发, 为提高内聚性就定义为内部接口
    interface Chain {

        // 获取当前request
        Request request();

        // 转发request
        Result proceed(Request request);
    }
}

class RealChain implements Ratify.Chain {

    private Request request;
    private List<Ratify> ratifyList;
    private int index;

    /**
     * @param request    具体请求实例
     * @param ratifyList Ratify接口实现集合
     * @param index      已经处理过的人数
     */
    public RealChain(Request request, List<Ratify> ratifyList, int index) {
        this.request = request;
        this.ratifyList = ratifyList;
        this.index = index;
    }

    @Override
    public Request request() {
        return request;
    }

    @Override
    public Result proceed(Request request) {
        Result result = null;
        if (ratifyList.size() > index) {
            Ratify ratify = ratifyList.get(index++);
            RealChain chain = new RealChain(request, ratifyList, index);
            result = ratify.deal(chain);
        }
        return result;
    }
}

// 组长-可批准2天及2天以内
class GroupLeader implements Ratify {

    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("GroupLeader===>request:" + request);
        if(request.getDays() > 2) {
            Request newRequest = new Request.Builder().newRequest(request)
                    .setGroupLeaderInfo(request.getName() + "平时表现不错,而且现在项目也不忙。").build();
            return chain.proceed(newRequest);
        }
        return new Result(true, "GroupLeader:早去早回");
    }
}

// 经理-可批准5天及5天以内
class Manager implements Ratify {

    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("Manager===>request:" + request);
        if(request.getDays() > 5) {
            Request newRequest = new Request.Builder().newRequest(request)
                    .setManagerInfo(request.getName() + "每月的KPI考核还不错，可以批准。").build();
            return chain.proceed(newRequest);
        }
        return new Result(true, "Manager:早点把事情办完，项目需要你。");
    }
}


// 部门领导-只批准7天及7天以内,大于7天不批
class DepartmentHeader implements Ratify {

    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("DepartmentHeader===>request:" + request);
        if(request.getDays() > 7) {
            return new Result(false, "DepartmentHeader:时间过长");
        }
        return new Result(true, "DepartmentHeader:不着急，把事情处理完再回来。");
    }
}
