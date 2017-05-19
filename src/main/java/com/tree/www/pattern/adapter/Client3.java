package com.tree.www.pattern.adapter;

/**
 * 对象适配器--关联, 多个需要适配时 java没有多继承。
 * 
 * @author pys
 *
 * @date 2016年4月12日 下午5:59:51
 */
public class Client3 {
	public static void main(String[] args) {
		Target target = new Adapter2();
		target.kill();
		Target target2 = new TargetClass();
		target2.kill();
	}

}



class Adapter2 implements Target {

	Adaptee ad = new AdapteeClass();
	@Override
	public void kill() {
		ad.biubiu();
	}

}
