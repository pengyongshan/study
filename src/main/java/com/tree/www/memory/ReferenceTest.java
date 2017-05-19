package com.tree.www.memory;

import java.lang.ref.WeakReference;

// 弱引用
public class ReferenceTest {

	public static void main(String[] args) {
		String str = new String("java");
		WeakReference wr = new WeakReference(str);
		str = null;
		System.out.println(wr.get());
		System.gc();
		System.runFinalization();
		System.out.println(wr.get());
	}
}
