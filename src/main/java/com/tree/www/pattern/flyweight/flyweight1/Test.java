package com.tree.www.pattern.flyweight.flyweight1;

/**
 * 1.start（）方法来启动线程，真正实现了多线程运行。这时无需等待run方法体代码执行完毕，可以直接继续执行下面的代码；
 * 通过调用Thread类的start()方法来启动一个线程， 这时此线程是处于就绪状态， 并没有运行。
 * 然后通过此Thread类调用方法run()来完成其运行操作的， 这里方法run()称为线程体，它包含了要执行的这个线程的内容， Run方法运行结束，
 * 此线程终止。然后CPU再调度其它线程。
 * 
 * 2.run（）方法当作普通方法的方式调用。程序还是要顺序执行，要等待run方法体执行完毕后，才可继续执行下面的代码； 程序中只有主线程——这一个线程，
 * 其程序执行路径还是只有一条， 这样就没有达到写线程的目的。
 * 
 * @author pys
 *
 * @date 2016年4月27日 下午3:18:38
 */
public class Test {

	public static void main(String[] args) {

		SignInfo signInfo = SignInfoFactory.getSignInfo("科目1");
		while (true) {
			signInfo.setId("ZhangSan");
			signInfo.setLocation("ZhangSan");
			(new MultiThread(signInfo)).start();
			signInfo.setId("LiSi");
			signInfo.setLocation("LiSi");
			(new MultiThread(signInfo)).start();
		}
	}
}
