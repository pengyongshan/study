package com.tree.www.pattern.adapter;

/**
 * 类适配器--继承 统一接口
 * 
 * @author pys
 *
 * @date 2016年4月12日 下午5:59:51
 */
public class Client2 {
	public static void main(String[] args) {
		Target target = new Adapter();
		target.kill();
		Target target2 = new TargetClass();
		target2.kill();
	}

}

interface Target {

	void kill();

}

class Adapter extends AdapteeClass implements Target {

	@Override
	public void kill() {
		biubiu();
	}

}
interface Adaptee {
	void biubiu();
}


class TargetClass implements Target {

	@Override
	public void kill() {
		System.out.println("杀人");
	}

}

class AdapteeClass implements Adaptee {

	@Override
	public void biubiu() {
		System.out.println("枪杀,biu biu....");
	}

}
