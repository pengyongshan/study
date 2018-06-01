package com.tree.www.pattern.composite.composite1;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 组合模式(安全)
 * Created by pysh on 2018/3/22.
 */
public class Client2 {
    public static void main(String[] args) {
        Component1 l1,l2,l3,l4;
        Composite1 c1,c2,c3,c4; // 安全模式不能抽象
        l1 = new Leaf1("l1");
        l2 = new Leaf1("l2");
        l3 = new Leaf1("l3");
        l4 = new Leaf1("l4");
        c1 = new Composite1("c1");
        c2 = new Composite1("c2");
        c3 = new Composite1("c3");
        c4 = new Composite1("c4");
        c1.add(l1);
        c1.add(l2);
        c1.add(c2);
        c2.add(l1);
        c2.add(l3);
        c2.add(c3);
        c3.add(c4);
        c3.add(l4);

        c1.display(0);
    }
}

abstract class Component1 {
    protected String name;

    public Component1(String name) {
        this.name = name;
    }
    public abstract void display(int depth);
}

class Leaf1 extends Component1 {

    public Leaf1(String name) {
        super(name);
    }

    @Override
    public void display(int depth) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <depth; i++) {
            sb.append("-");
        }
        System.out.println(sb + name);
    }
}

class Composite1 extends Component1 {

    private List<Component1> list = Lists.newArrayList();

    public Composite1(String name) {
        super(name);
    }

    @Override
    public void display(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < depth; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder + name);
        for (Component1 component1 : list) {
            component1.display(depth + 1);
        }
    }

    public void add(Component1 component1) {
        list.add(component1);
    }

    public void remove(Component1 component1) {
        list.remove(component1);
    }

}
