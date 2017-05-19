package com.tree.www.pattern.proxy;

public class WanPo implements KindWomen {

	private KindWomen kindWomen;

	public WanPo() {
		this.kindWomen = new PanJinLian(); // 默认是潘金莲的代理
	}

	public WanPo(KindWomen kindWomen) {
		this.kindWomen = kindWomen;
	}

	@Override
	public void makeEyesWithMan() {
		this.kindWomen.makeEyesWithMan();
	}

	@Override
	public void happyWithMan() {
		this.kindWomen.happyWithMan();
	}

}
