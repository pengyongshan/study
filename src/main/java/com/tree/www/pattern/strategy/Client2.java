package com.tree.www.pattern.strategy;

/**
 * Created by pysh on 2018/3/7.
 */
public class Client2 {
    public static void main(String[] args) {
        Context_SalesMan mSalesMan;
        System.out.println("对于春节：");
        mSalesMan = new Context_SalesMan("A");
        mSalesMan.salesManShow();

        System.out.println("对于中秋节：");
        mSalesMan = new Context_SalesMan("B");
        mSalesMan.salesManShow();

        System.out.println("对于圣诞节：");
        mSalesMan = new Context_SalesMan("C");
        mSalesMan.salesManShow();
    }
}

abstract class Strategy {
    public abstract void show();
}

class StrategyA extends Strategy {

    @Override
    public void show() {
        System.out.println("为春节准备的促销活动A");
    }
}

class StrategyB extends Strategy {

    @Override
    public void show() {
        System.out.println("为中秋准备的促销活动B");
    }
}


class StrategyC extends Strategy {

    @Override
    public void show() {
        System.out.println("为圣诞节准备的促销活动C");
    }
}

class Context_SalesMan {
    private Strategy strategy;

    public Context_SalesMan(String festival) {
        switch (festival) {
            case "A":
                this.strategy = new StrategyA();
                break;
            case "B":
                this.strategy = new StrategyB();
                break;
            case "C":
                this.strategy = new StrategyC();
                break;
        }
    }

    public void salesManShow() {
        this.strategy.show();
    }
}
