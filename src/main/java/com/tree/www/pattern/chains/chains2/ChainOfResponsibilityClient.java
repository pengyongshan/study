package com.tree.www.pattern.chains.chains2;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 工具类
 * <p>
 * Created by pysh on 2018/6/4.
 */
public class ChainOfResponsibilityClient {
    private List<Ratify> ratifyList;

    public ChainOfResponsibilityClient() {
        ratifyList = Lists.newArrayList();
    }

    public void addRatify(Ratify ratify) {
        ratifyList.add(ratify);
    }

    public Result execute(Request request) {
        List<Ratify> ratifies = Lists.newArrayList(ratifyList);
        ratifies.add(new GroupLeader());
        ratifies.add(new Manager());
        ratifies.add(new DepartmentHeader());
        RealChain chain = new RealChain(request, ratifies, 0);
        return chain.proceed(request);
    }
}
