package com.tree.www.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截过滤器模式
 * <p>
 * 用于对应用程序的请求或响应做一些预处理/后处理
 * <p>
 * Created by pysh on 2018/6/7.
 */
public class FilterDemo {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
        filterManager.filterRequest("HOME");
        //Client client = new Client();
        //client.setFilterManager(filterManager);
        //client.sendRequest("HOME");
    }
}

interface Filter {
    void exec(String request);
}

class AuthenticationFilter implements Filter {

    @Override
    public void exec(String request) {
        System.out.println("authenticating request:" + request);
    }
}

class DebugFilter implements Filter {

    @Override
    public void exec(String request) {
        System.out.println("request log:" + request);
    }
}

class Target implements Filter {

    @Override
    public void exec(String request) {
        System.out.println("executing request:" + request);
    }
}

class FilterChain {
    private List<Filter> filters = new ArrayList<>();

    private Target target;

    public void exec(String request) {
        for (Filter filter : filters) {
            filter.exec(request);
        }
        target.exec(request);
    }

    public void addFilter(Filter filter) {
        if (!filters.contains(filter)) {
            filters.add(filter);
        }
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}

class FilterManager {
    private FilterChain filterChain;

    public FilterManager(Target target) {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.exec(request);
    }
}
//
//class Client {
//    private FilterManager filterManager;
//
//    public void setFilterManager(FilterManager filterManager) {
//        this.filterManager = filterManager;
//    }
//
//    public void sendRequest(String request) {
//        filterManager.filterRequest(request);
//    }
//}

