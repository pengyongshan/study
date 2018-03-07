package com.tree.www.pattern.factoryMethod;

/**
 * Created by pysh on 2018/3/7.
 */
public class FactoryA extends Factory {
    @Override
    public Product manufacture() {
        return new ProductA();
    }
}
