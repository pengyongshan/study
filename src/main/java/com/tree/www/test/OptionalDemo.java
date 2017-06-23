package com.tree.www.test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by pysh on 2017/6/2.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Sanaulla");

        Optional<String> empty = Optional.empty();

        name.ifPresent(System.out::println);

        try {
            System.out.println(empty.get());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        name.ifPresent(value -> System.out.println("the length of the value is: " + value.length()));

        System.out.println(name.orElse("There is some value"));
        System.out.println(empty.orElse("There is no value present"));

        System.out.println(name.orElseGet(() -> "default value"));
        System.out.println(empty.orElseGet(() -> "default value"));

        try {
            String xx = "xxx";
            empty.orElseThrow(Exception::new);
        } catch (Throwable th) {
            System.out.println(th.getMessage());
        }

        //map方法通过传入的lambda表达式修改Optonal实例默认值。
        //lambda表达式返回值会包装为Optional实例。
        Optional<String> upperName = name.map(String::toUpperCase);
        System.out.println(upperName.orElse("no value found"));

        //flatMap与map（Funtion）非常相似，区别在于lambda表达式的返回值。
        //map方法的lambda表达式返回值可以是任何类型，但是返回值会包装成Optional实例。
        //但是flatMap方法的lambda返回值总是Optional类型。
        upperName = name.flatMap(value -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("no value found"));

        Optional<String> longName = name.filter(value -> value.length() > 6);
        System.out.println(longName.orElse("the name is less than 6 characters"));

        Optional<String> anotherName = Optional.of("Sana");
        Optional<String> shortName = anotherName.filter(value -> value.length() > 6);
        System.out.println(shortName.orElse("the name is less than 6 characters"));
    }
}
