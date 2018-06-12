/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.tree.www.guava;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 多列排序
 *
 * @author pengyongshan
 * @version $Id: ComparisonChainTest.java, v 0.1 2016年12月12日 下午7:45:57 pengyongshan Exp $
 */
public class ComparisonChainTest {
    public static void main(String[] args) {
        List<Person> list = Lists.newArrayList();
        list.add(new Person("cc", 11, 22));
        list.add(new Person("aa", 13, 22));
        list.add(new Person("bb", 11, 32));
        list.add(new Person("aa", 11, 22));
        list.add(new Person("cc", 11, 22));
        list.add(new Person("bb", 12, 32));

        list.sort((o1, o2) -> ComparisonChain.start()
                .compare(o1.getAge(), o2.getAge())
                .compare(o1.getScore(), o2.getScore())
                .result());

        for (Person person : list) {
            System.out.println(person);
        }
    }
}

class Person {
    private String name;

    private int age;

    private int score;

    public Person(String name, int age, int score) {
        super();
        this.name = name;
        this.age = age;
        this.score = score;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for property <tt>age</tt>.
     *
     * @return property value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter method for property <tt>score</tt>.
     *
     * @return property value of score
     */
    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", score=" + score + "]";
    }

}
