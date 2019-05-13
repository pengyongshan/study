package com.tree.www.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by pysh on 2019-02-25.
 * <p>
 * mockito文档阅读 11-20
 */
@RunWith(MockitoJUnitRunner.class)
public class Mockito11_20 {

    @Test // 为回调做测试桩, 绝大多数情况 thenReturn、thenThrow就够了
    public void test11() {
        List mockList = mock(List.class);
        when(mockList.contains(anyString())).thenAnswer((Answer) invocationOnMock -> {
            Object[] args = invocationOnMock.getArguments();
            Object mock = invocationOnMock.getMock();
            System.out.println("called with arguments:" + args);
            return true;
        });
        System.out.println(mockList.contains("foo"));
    }

    // 12 doReturn()、doThrow()、doAnswer()、doNothing()、doCallRealMethod()系列方法的运用

    @Test // 监控真实对象 spy 当你使用这个spy对象时真实的对象也会也调用，除非它的函数被stub了。
    // 尽量少使用spy对象，使用时也需要小心形式，例如spy对象可以用来处理遗留代码。
    public void test13() {
        List list = new LinkedList();
        List spy = spy(list);

        when(spy.size()).thenReturn(100);
        System.out.println(spy.size());

        spy.add("one");
        spy.add("two");

        //when(spy.get(10)).thenReturn("foo"); // IndexOutOfBoundsException
        doReturn("foo").when(spy).get(10);
        System.out.println(spy.get(10));

        verify(spy).add("one");
        verify(spy).add("two");
    }

    //14 修改没有测试桩的调用的默认返回值 很少使用
    // Foo mock = mock(Foo.class, Mockito.RETURNS_SMART_NULLS);
    // Foo mockTwo = mock(Foo.class, new YourOwnAnswer()); 指定自定义策略

    //15 为下一步的断言捕获参数
    @Test
    public void test15() {
        ArgumentCaptor<Person> argumentCaptor = ArgumentCaptor.forClass(Person.class);
        Person mock = mock(Person.class);
        mock.sayHello(new Person("John"));
        verify(mock).sayHello(argumentCaptor.capture());
        assertEquals("John", argumentCaptor.getValue().getName());
    }

    @Test // 真正的局部mocks, 一般不用
    public void test16() {
        //you can create partial mock with spy() method:
        List list = spy(new LinkedList());

        // ## you can enable partial mock capabilities selectively on mocks:
        //Foo mock = mock(Foo.class);
        // ## Be sure the real implementation is 'safe'.
        // ## If real implementation throws exceptions or depends on specific state of the object then you're in trouble.
        //when(mock.someMethod()).thenCallRealMethod();
    }

    // 17 reset(mock); 重置mocks对象, 聪明的 Mockito 使用者很少会用到这个特性，因为他们知道这是出现糟糕测试单元的信号。
    // 通常情况下你不会需要重设你的测试单元，只需要为每一个测试方法重新创建一个测试单元就可以了

    // 18 故障FAQ

    // 19 BDD

    // 20 序列化mock对象  很少使用
    // List serializableMock = mock(List.class, withSettings().serializable());
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(Person person) {
        System.out.println(person.getName());
    }
}
