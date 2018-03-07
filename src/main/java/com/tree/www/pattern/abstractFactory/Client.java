package com.tree.www.pattern.abstractFactory;

/**
 * 抽象工厂模式
 *
 * Created by pysh on 2018/3/7.
 */
public class Client {
    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        FactoryB factoryB = new FactoryB();

        factoryA.manufactureContainer().show();
        factoryA.manufactureMould().show();

        factoryB.manufactureContainer().show();
        factoryB.manufactureMould().show();
    }
}

/**
 应用场景

 一个系统不要求依赖产品类实例如何被创建、组合和表达的表达，这点也是所有工厂模式应用的前提。
 这个系统有多个系列产品，而系统中只消费其中某一系列产品
 系统要求提供一个产品类的库，所有产品以同样的接口出现，客户端不需要依赖具体实现。
 */

abstract class Factory {
    public abstract AbstractProduct manufactureContainer();
    public abstract AbstractProduct manufactureMould();
}

abstract class AbstractProduct {
    public abstract void show();
}

abstract class ContainerProd extends AbstractProduct{

}

abstract class MouldProd extends AbstractProduct{

}

class ContainerProdA extends ContainerProd {

    @Override
    public void show() {
        System.out.println("生产出了容器产品A");
    }
}

class ContainerProdB extends ContainerProd {

    @Override
    public void show() {
        System.out.println("生产出了容器产品B");
    }
}

class MouldProdA extends MouldProd {

    @Override
    public void show() {
        System.out.println("生产出了模具产品A");
    }
}

class MouldProdB extends MouldProd {

    @Override
    public void show() {
        System.out.println("生产出了模具产品B");
    }
}

class FactoryA extends Factory {

    @Override
    public AbstractProduct manufactureContainer() {
        return new ContainerProdA();
    }

    @Override
    public AbstractProduct manufactureMould() {
        return new MouldProdA();
    }
}

class FactoryB extends Factory {

    @Override
    public AbstractProduct manufactureContainer() {
        return new ContainerProdB();
    }

    @Override
    public AbstractProduct manufactureMould() {
        return new MouldProdB();
    }
}
