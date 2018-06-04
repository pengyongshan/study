package com.tree.www.pattern.chains.chains2;

/**
 * 自定义 责任人 - 动态扩展链
 * Created by pysh on 2018/6/4.
 */
public class CustomInterceptor implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("CustomInterceptor===>request:" + request);
        if(request != null && request.getReason().equals("事假")) {
            Request newRequest = new Request.Builder().newRequest(request)
                    .setCustomInfo(request.getName() + "事假，很急，请领导重视").build();
            System.out.println("CustomInterceptor=>转发请求");
            return chain.proceed(newRequest);
        }
        return new Result(true, "同意请假");
    }
}
