package com.tree.www.pattern.observer.observer2;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by pysh on 2018/6/6.
 */
public class Client {
    public static void main(String[] args) {
        User u1 = new User("aaa");
        User u2 = new User("bbb");
        User u3 = new User("ccc");
        WechatServer weChat = new WechatServer();
        weChat.addObserver(u1);
        weChat.addObserver(u1);
        weChat.addObserver(u1);
        weChat.addObserver(u2);
        weChat.addObserver(u3);
        weChat.setMsg("java是最好的语言");

        weChat.removeObserver(u1);
        System.out.println("-----------------------------------");
        weChat.setMsg("php是最好的语言");
    }
}

interface Observable {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

interface Observer {
    void update(String msg);
}

class WechatServer implements Observable {

    private List<Observer> list;
    private String msg;

    public WechatServer() {
        list = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        if(list.contains(o)) {
            return;
        }
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : list) {
            observer.update(msg);
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
        System.out.println("微信服务更新消息：" + msg);
        notifyObservers();
    }
}

class User implements Observer {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println("[" + name + "]收到消息:" + msg);
    }
}
