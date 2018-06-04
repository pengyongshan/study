package com.tree.www.pattern.chains.chains2;

/**
 * 在公司内部员工请假一般情况是这样的：员工在OA系统中提交一封请假邮件，该邮件会自动转发到你的直接上级领导邮箱里，
 * 如果你的请假的情况特殊的话，该邮件也会转发到你上级的上级的邮箱，根据请假的情况天数多少，
 * 系统会自动转发相应的责任人的邮箱。
 * Created by pysh on 2018/6/4.
 */
public class Client {
    public static void main(String[] args) {
        Request request = new Request.Builder().setName("张三").setDays(8).setReason("事假").build();
        ChainOfResponsibilityClient client = new ChainOfResponsibilityClient();
        client.addRatify(new CustomInterceptor());
        System.out.println(client.execute(request));
    }
}
