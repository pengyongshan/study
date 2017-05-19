package com.tree.www.io.nio;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		CharBuffer buff = CharBuffer.allocate(8);
		System.out.println("capacity:" + buff.capacity());
		System.out.println("limit:" + buff.limit());
		System.out.println("position:" + buff.position());

		buff.put('a');
		buff.put('b');
		buff.put('c');
		System.out.println("after put() position:" + buff.position());

		buff.flip();
		System.out.println("after flip() limit:" + buff.limit());
		System.out.println("position:" + buff.position());

		System.out.println(buff.get());
		System.out.println("after get() position:" + buff.position());

		buff.clear();
		System.out.print("after clear() capacity:" + buff.capacity());
		System.out.print(";limit:" + buff.limit());
		System.out.println(";position:" + buff.position());
		buff.put(1, 'k'); // 不影响position位置

		System.out.println(buff.get());
	}
}
