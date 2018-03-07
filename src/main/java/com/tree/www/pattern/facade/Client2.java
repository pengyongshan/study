package com.tree.www.pattern.facade;

/**
 * Created by pysh on 2018/3/7.
 */
public class Client2 {
    public static void main(String[] args) {
        Facade person = new Facade();
        person.sleep();
        System.out.println("睡觉了....");

        System.out.println();
        System.out.println("起床了...");
        person.getUp();
    }
}


interface DianQi {
    void on();
    void off();
}

class Light implements DianQi {

    @Override
    public void on() {
        System.out.println("开灯");
    }

    @Override
    public void off() {
        System.out.println("关灯");
    }
}

class KongTiao implements DianQi {

    @Override
    public void on() {
        System.out.println("开空调");
    }

    @Override
    public void off() {
        System.out.println("关空调");
    }
}

class TV implements DianQi {

    @Override
    public void on() {
        System.out.println("开电视");
    }

    @Override
    public void off() {
        System.out.println("关电视");
    }
}

class Facade {
    KongTiao kongTiao; TV tv; Light light;

    public Facade() {
        this.kongTiao = new KongTiao();
        this.tv = new TV();
        this.light = new Light();
    }
    void getUp() {
        kongTiao.on();
        tv.on();
        light.on();
    }

    void sleep() {
        kongTiao.off();
        tv.off();
        light.off();
    }

}
