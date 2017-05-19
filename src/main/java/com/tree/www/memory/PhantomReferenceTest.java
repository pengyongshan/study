package com.tree.www.memory;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

// 虚引用 需与队列联合使用
public class PhantomReferenceTest {

	public static void main(String[] args) throws Exception {
		String str = new String("java");
		ReferenceQueue rq = new ReferenceQueue();
		PhantomReference pr = new PhantomReference(str, rq);
		str = null;
		System.out.println(pr.get());
		System.gc();
		System.runFinalization();
		// 垃圾回收后，虚引用将被放入引用队列中。
		System.out.println(pr == rq.poll());
	}
}
