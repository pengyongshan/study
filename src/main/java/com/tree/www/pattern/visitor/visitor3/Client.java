package com.tree.www.pattern.visitor.visitor3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pysh on 2018/6/7.
 */
public class Client {
    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();
        accountBook.addBill(new ConsumBill(20000, "工资"));
        accountBook.addBill(new ConsumBill(1000, "材料费"));
        accountBook.addBill(new ConsumBill(3000, "餐补"));
        accountBook.addBill(new IncomeBill(3000, "卖广告位"));
        accountBook.addBill(new IncomeBill(50000, "卖商品"));
        accountBook.addBill(new IncomeBill(5000, "项目补贴"));
        Boss boss = new Boss();
        AccountBookViewer cpa = new CPA();
        AccountBookViewer cfo = new CFO();

        accountBook.show(boss);
        accountBook.show(cpa);
        accountBook.show(cfo);

        System.out.println("-------------------------------");
        double totalConsume = boss.getTotalConsume();
        double totalIncome = boss.getTotalIncome();
        System.out.println("盈利：" + (totalIncome - totalConsume));
    }
}

// 账单
interface Bill {
    void accept(AccountBookViewer viewer);
}

abstract class AbstractBill implements Bill {
    protected double amount;
    protected String item;

    public AbstractBill(double amount, String item) {
        this.amount = amount;
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public String getItem() {
        return item;
    }
}

// 消费
class ConsumBill extends AbstractBill {

    public ConsumBill(double amount, String item) {
        super(amount, item);
    }

    @Override
    public void accept(AccountBookViewer viewer) {
        viewer.view(this);
    }
}

// 收入
class IncomeBill extends AbstractBill {

    public IncomeBill(double amount, String item) {
        super(amount, item);
    }

    @Override
    public void accept(AccountBookViewer viewer) {
        viewer.view(this);
    }
}

//账单查看者接口
interface AccountBookViewer {
    void view(ConsumBill bill);

    void view(IncomeBill bill);
}

class Boss implements AccountBookViewer {

    private double totalIncome;
    private double totalConsume;

    @Override
    public void view(ConsumBill bill) {
        totalConsume += bill.getAmount();
    }

    @Override
    public void view(IncomeBill bill) {
        totalIncome += bill.getAmount();
    }

    public double getTotalIncome() {
        System.out.println("老板查看一共收入多少，数目是：" + totalIncome);
        return totalIncome;
    }

    public double getTotalConsume() {
        System.out.println("老板查看一共支出多少，数目是：" + totalConsume);
        return totalConsume;
    }
}

class CPA implements AccountBookViewer {

    @Override
    public void view(ConsumBill bill) {
        if (bill.getItem().contains("工资")) {
            System.out.println("注会查看【" + bill.getItem() + "】支出是否上交个人所得税");
        }
    }

    @Override
    public void view(IncomeBill bill) {
        System.out.println("注会查看【" + bill.getItem() + "】收入交税了没");
    }
}

class CFO implements AccountBookViewer {

    @Override
    public void view(ConsumBill bill) {
        System.out.println("财务主管查看账本时，每一个都核对项目和金额，【消费】金额是" + bill.getAmount() + "，项目是" + bill.getItem());
    }

    @Override
    public void view(IncomeBill bill) {
        System.out.println("财务主管查看账本时，每一个都核对项目和金额，【收入】金额是" + bill.getAmount() + "，项目是" + bill.getItem());
    }
}

class AccountBook {
    private List<Bill> billList = new ArrayList<>();

    public void addBill(Bill bill) {
        billList.add(bill);
    }

    public void show(AccountBookViewer viewer) {
        for (Bill bill : billList) {
            bill.accept(viewer);
        }
        System.out.println();
    }
}
