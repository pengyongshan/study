package com.tree.www.pattern.proxy;

/**
 * Created by pysh on 2018/3/7.
 */
public class Client2 {
    public static void main(String[] args) {
        Subject proxy = new Proxy(new RealSubject());
        proxy.buyMac();
    }
}

interface Subject {
    void buyMac();
}

class RealSubject implements Subject {

    @Override
    public void buyMac() {
        System.out.println("买一台电脑");
    }
}

class Proxy implements Subject {

    private Subject subject;

    Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void buyMac() {
        subject.buyMac();
        wrapMac();
    }

    private void wrapMac() {
        System.out.println("用盒子装好电脑");
    }
}
