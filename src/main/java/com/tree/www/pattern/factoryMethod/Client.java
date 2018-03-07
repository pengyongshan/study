package com.tree.www.pattern.factoryMethod;

/**
 * 简单工厂模式
 *
 * https://www.jianshu.com/p/d0c444275827
 *
 * Created by pysh on 2018/3/7.
 */
public class Client {
    public static void main(String[] args) {
        FactoryA mfacA = new FactoryA();
        mfacA.manufacture().show();

        FactoryB mfacB = new FactoryB();
        mfacB.manufacture().show();
    }
}

/**
 应用场景

 当一个类不知道它所需要的对象的类时
 在工厂方法模式中，客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可；
 当一个类希望通过其子类来指定创建对象时
 在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，利用面向对象的多态性和里氏代换原则，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展。
 将创建对象的任务委托给多个工厂子类中的某一个，客户端在使用时可以无须关心是哪一个工厂子类创建产品子类，需要时再动态指定，可将具体工厂类的类名存储在配置文件或数据库中。

 */
