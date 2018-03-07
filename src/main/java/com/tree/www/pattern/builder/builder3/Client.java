package com.tree.www.pattern.builder.builder3;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by pysh on 2018/3/7.
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new Builder1();
        director.construct(builder);

        Computer computer = builder.getCompute();
        computer.show();
    }
}

//定义组装过程
abstract class Builder {
    public abstract void buildCPU();
    public abstract void buildMainboard();
    public abstract void buildHD();

    public abstract Computer getCompute();
}

class Builder1 extends Builder {

    private Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.add("CPU");
    }

    @Override
    public void buildMainboard() {
        computer.add("主板");
    }

    @Override
    public void buildHD() {
        computer.add("显示屏");
    }

    @Override
    public Computer getCompute() {
        return computer;
    }
}

// 老板委派任务给装机人员
class Director {
    // 组装
    public void construct(Builder builder) {
        builder.buildCPU();
        builder.buildMainboard();
        builder.buildHD();
    }
}

class Computer {
    private List<String> parts = Lists.newArrayList();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        for (String part : parts) {
            System.out.println("组件" + part + "装好了");
        }

        System.out.println("装机完成");
    }
}
