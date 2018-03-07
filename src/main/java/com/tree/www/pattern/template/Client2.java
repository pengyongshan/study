package com.tree.www.pattern.template;

/**
 * Created by pysh on 2018/3/7.
 */
public class Client2 {
    public static void main(String[] args) {
        AbstractCookVegetable cookVegetable1 = new CookBaoCai();
        System.out.println("炒包菜流程:");
        cookVegetable1.cookProcess();
        System.out.println();
        AbstractCookVegetable cookVegetable2 = new CookCaiXin();
        System.out.println("炒菜心流程:");
        cookVegetable2.cookProcess();
    }
}

abstract class AbstractCookVegetable {
    public final void cookProcess() {
        this.pourOil();
        this.heatOil();
        this.pourVegetable();
        this.pourSauce();
        this.fry();
    }

    private void fry() {
        System.out.println("翻炒");
    }

    protected abstract void pourSauce();

    protected abstract void pourVegetable();

    private void heatOil() {
        System.out.println("热油");
    }

    private void pourOil() {
        System.out.println("倒油");
    }
}

class CookBaoCai extends AbstractCookVegetable {

    @Override
    protected void pourSauce() {
        System.out.println("放辣椒");
    }

    @Override
    protected void pourVegetable() {
        System.out.println("下包菜");
    }
}

class CookCaiXin extends AbstractCookVegetable {

    @Override
    protected void pourSauce() {
        System.out.println("放蒜蓉");
    }

    @Override
    protected void pourVegetable() {
        System.out.println("下菜心");
    }
}
