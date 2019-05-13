package com.tree.www.mockito;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by pysh on 2019-02-25.
 * <p>
 * mockito文档阅读 21-35
 */
@RunWith(MockitoJUnitRunner.class)
public class Mockito21_35 {

    // 21 新的注解 @Capitor, @Spy, @InjectMcoks
    // @Captor 简化 ArgumentCaptor 的创建 - 当需要捕获的参数是一个令人讨厌的通用类，而且你想避免编译时警告。
    // @Spy 替代 spy(obj)方法
    // @InjectMcoks 自动将模拟对象或侦查域注入到被测试对象中。需要注意的是 @InjectMocks
    // 也能与 @Spy 一起使用，这就意味着 Mockito 会注入模拟对象到测试的部分测试中。
    // 它的复杂度也是你应该使用部分测试原因。

    //22 验证超时
    // 允许带有暂停的验证。这使得一个验证去等待一段特定的时间，
    // 以获得想要的交互而不是如果还没有发生事件就带来的立即失败。在并发条件下的测试这会很有用。
    /***
     *    //passes when someMethod() is called within given time span
     *    verify(mock, timeout(100)).someMethod();
     *    //above is an alias to:
     *    verify(mock, timeout(100).times(1)).someMethod();
     *
     *    //passes when someMethod() is called *exactly* 2 times within given time span
     *    verify(mock, timeout(100).times(2)).someMethod();
     *
     *    //passes when someMethod() is called *at least* 2 times within given time span
     *    verify(mock, timeout(100).atLeast(2)).someMethod();
     *
     *    //verifies someMethod() within given time span using given verification mode
     *    //useful only if you have your own custom verification modes.
     *    verify(mock, new Timeout(100, yourOwnVerificationMode)).someMethod();
     */

    // 23 自动初始化
    /**
     *  //instead:
     *  @Spy BeerDrinker drinker = new BeerDrinker();
     *  //you can write:
     *  @Spy BeerDrinker drinker;
     *
     *  //same applies to @InjectMocks annotation:
     *  @InjectMocks LocalPub;
     */

    // 24 单行测试桩
    // 允许你在使用测试桩时创建模拟对象。基本上，它允许在一行代码中创建一个测试桩，这对保持代码的整洁很有用。
    /**
     * public class CarTest {
     *     Car boringStubbedCar = when(mock(Car.class).shiftGear()).thenThrow(EngineNotStarted.class).getMock();
     *     @Test public void should... {...}
     * }
     */

    // 25.验证被忽略的测试桩
    /**
     *  verify(mock).foo();
     *  verify(mockTwo).bar();
     *
     *  //ignores all stubbed methods:
     *  verifyNoMoreInvocations(ignoreStubs(mock, mockTwo));
     *
     *  //creates InOrder that will ignore stubbed
     *  InOrder inOrder = inOrder(ignoreStubs(mock, mockTwo));
     *  inOrder.verify(mock).foo();
     *  inOrder.verify(mockTwo).bar();
     *  inOrder.verifyNoMoreInteractions();
     */

    // 26. mock详情
    //Mockito.mockingDetails(someObject).isMock(); 是否模拟对象
    //Mockito.mockingDetails(someObject).isSpy();  是否侦查对象
    // 是侦查对象=>是模拟对象.  因为一个侦查对象只是模拟对象的一种变种

    // 27. 委托调用真实案例  AdditionalAnswers.delegatesTo(Object).

    // 28. MockMaker API 测试Android

    // 29. (new) BDD 风格的验证
    /**
     * given(dog.bark()).willReturn(2);
     *  // when
     *  ...
     *  then(person).should(times(2)).ride(bike);
     */

    // 30. Spying 或 mocking 抽象类
    /**
     * //convenience API, new overloaded spy() method:
     *  SomeAbstract spy = spy(SomeAbstract.class);
     *
     *  //Robust API, via settings builder:
     *  OtherAbstract spy = mock(OtherAbstract.class, withSettings()
     *     .useConstructor().defaultAnswer(CALLS_REAL_METHODS));
     *
     *  //Mocking a non-static inner abstract class:
     *  InnerAbstract spy = mock(InnerAbstract.class, withSettings()
     *     .useConstructor().outerInstance(outerInstance).defaultAnswer(CALLS_REAL_METHODS));
     *
     *    MockSettings.useConstructor() .
     */

    // 31 (new) Mockito mocks 可以通过 classloaders 序列化/反序列化
    /**
     * // 常规的 serialization
     * mock(Book.class, withSettings().serializable());
     *
     * // 通过 classloaders 序列化
     * mock(Book.class, withSettings().serializable(ACROSS_CLASSLOADERS));
     */

    // 32 Deep stubs 更好的泛型支持
    // Deep stubbing 现在可以更好的查找类的泛型信息。
    // 这就意味着像这样的类 不必去 mock 它的行为就可以使用。
    /**
     * class Lines extends List<Line> {
     *      // ...
     *  }
     *
     *  lines = mock(Lines.class, RETURNS_DEEP_STUBS);
     *
     *  // Now Mockito understand this is not an Object but a Line
     *  Line line = lines.iterator().next();
     */

    // 33. Mockito JUnit rule 选择rule.
    /**
     * @RunWith(YetAnotherRunner.class)
     *  public class TheTest {
     *      @Rule public MockitoRule mockito = MockitoJUnit.rule();
     *      // ...
     *  }
     */

    // 34 开启和关闭 plugins. PluginSwitch

    // 35. 自定义验证失败信息. 允许声明一个在验证失败时输出的自定义消息
    /**
     *  // will print a custom message on verification failure
     *  verify(mock, description("This will print on failure")).someMethod();
     *
     *  // will work with any verification mode
     *  verify(mock, times(2).description("someMethod should be called twice")).someMethod();
     */

}
