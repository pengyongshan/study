package com.tree.www.pattern.mediator.mediator3;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by pysh on 2018/6/1.
 */
public class Mediator3 {

    public static void main(String[] args) {
        AbstractMediator mediator = new Mediator();
        AbstractColleague colleagueA = new ColleagueA();
        AbstractColleague colleagueB = new ColleagueB();
        mediator.addColleague("ColleagueA", colleagueA);
        mediator.addColleague("ColleagueB", colleagueB);

        colleagueA.self();
        colleagueA.out();
        colleagueB.self();
        colleagueB.out();
    }
}

abstract class AbstractColleague {
    protected AbstractMediator mediator;

    public void setAbstractMediator(AbstractMediator abstractMediator) {
        this.mediator = abstractMediator;
    }

    public abstract void self();

    public abstract void out();
}

class ColleagueA extends AbstractColleague {

    @Override
    public void self() {
        System.out.println("同事A-->做好自己分内的事情...");
    }

    @Override
    public void out() {
        System.out.println("同事A-->请求同事B做好自己分内的事情...");
        mediator.execute("ColleagueB", "self");
    }
}

class ColleagueB extends AbstractColleague {

    @Override
    public void self() {
        System.out.println("同事B-->做好自己分内的事情...");
    }

    @Override
    public void out() {
        System.out.println("同事B-->请求同事A做好自己分内的事情...");
        mediator.execute("ColleagueA", "self");
    }
}

abstract class AbstractMediator {
    protected Map<String, AbstractColleague> colleagues = new HashMap<>();

    public void addColleague(String name, AbstractColleague colleague) {
        colleague.setAbstractMediator(this);
        colleagues.put(name, colleague);
    }

    public void deleteColleague(String name) {
        colleagues.remove(name);
    }

    public abstract void execute(String name, String method);
}

class Mediator extends AbstractMediator {

    @Override
    public void execute(String name, String method) {
        if ("self".equals(method)) {
            colleagues.get(name).self();
        } else {
            colleagues.get(name).out();
        }
    }
}
