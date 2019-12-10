package com.tree.www.clone;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * 序列化与反序列化克隆
 * <p>
 * Created by pysh on 2019-11-06.
 */
public final class CloneUtil {

    /***
     * 没有Serializable会报NotSerializableException
     * {@link ObjectOutputStream 1184}
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        return (T) ois.readObject();
        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.setName("彭勇善");
        person.setAge(26);
        Person personC = clone(person);
        System.out.println(JSON.toJSON(personC));
        personC.setName("彭勇善C");
        System.out.println(JSON.toJSON(person));
        System.out.println(JSON.toJSON(personC));
    }
}

class Person implements Serializable {

    private static final long serialVersionUID = -309337181605660118L;

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
