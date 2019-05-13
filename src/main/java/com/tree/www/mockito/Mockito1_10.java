package com.tree.www.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by pysh on 2019-02-25.
 * <p>
 * mockito文档阅读 1-10
 */
@RunWith(MockitoJUnitRunner.class)
public class Mockito1_10 {

    @Test // 验证某些行为
    public void testVerify() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();

        // mock对象会记住所有的交互
        verify(mockedList).add("one");
        //verify(mockedList).add("two");
        verify(mockedList).clear();
    }

    @Test // 打桩
    public void testStub() {
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(2));// 没打桩return null
    }

    @Test // 参数匹配
    public void testMatchers() {
        List mockedList = mock(List.class);
        // 内置匹配器
        when(mockedList.get(anyInt())).thenReturn("element");
        System.out.println(mockedList.get(19288199));
        // 自定义匹配器
        //when(mockedList.contains(argThat(isValid())).thenReturn("element");

        verify(mockedList).get(anyInt());
    }

    @Test //  验证函数的确切、最少、从未调用次数
    public void test4() {
        List mockedList = mock(List.class);
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        // 等效，默认就是一次 never()是0次
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");
        verify(mockedList, never()).add("xxxx");

        // 具体次数
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");


        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }

    @Test // 指定函数被调用时抛异常
    public void test5() {
        List mockedList = mock(List.class);
        doThrow(new RuntimeException()).when(mockedList).add(anyInt());

        mockedList.add("one");
        mockedList.add(1782);
    }

    @Test // 验证执行执行顺序
    public void test6() {
        // 验证mock一个对象的函数执行顺序
        List singleMock = mock(List.class);
        singleMock.add("was added first");
        singleMock.add("was added second");

        InOrder inOrder = inOrder(singleMock);

        // 确保add函数首先执行的是add("was added first"),然后才是add("was added second")
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // 验证多个mock对象的函数执行顺序
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        firstMock.add("was called first");
        secondMock.add("was called second");

        InOrder inOrder2 = inOrder(firstMock, secondMock);

        inOrder2.verify(firstMock).add("was called first");
        inOrder2.verify(secondMock).add("was called second");

    }

    @Test // 确保交互操作不会执行在mock对象上
    public void test7() {
        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);
        List mockThree = mock(List.class);

        mockOne.add("one");
        verify(mockOne).add("one");

        //mockTwo.add("two");

        verify(mockOne, never()).add("two");

        // 验证mock对象没有交互过
        verifyZeroInteractions(mockTwo, mockThree);
    }

    @Test // 查找冗余的调用
    public void test8() {
        List mockList = mock(List.class);
        mockList.add("one");
        mockList.add("two");

        verify(mockList).add("one");
        //verify(mockList).add("two");

        verifyNoMoreInteractions(mockList);
    }

    // 简化mock对象的创建

    /***
     * public class XxxTest {
     *      @Mock private Xxx xxx;
     *      @Mock private Xxx1 xxx1;
     *      @Mock private Xxx2 xxx2;
     * }
     *
     *  MockitoAnnotations.initMocks(testClass);
     */

    @Test // 为连续的调用做测试桩
    public void test10() {
        List mockList = mock(List.class);
        when(mockList.size()).thenThrow(new RuntimeException())
                .thenReturn(4);
        try {
            System.out.println(mockList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(mockList.size());

        when(mockList.size()).thenReturn(4, 5, 6);
        System.out.println(mockList.size()); // 4
        System.out.println(mockList.size()); // 5
        System.out.println(mockList.size()); // 6
        System.out.println(mockList.size()); // 6
        System.out.println(mockList.size()); // 6
    }

}
