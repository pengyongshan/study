package com.tree.www.pattern.chains;

public class Son extends Handler {

	public Son() {
		super(TypeEnum.SON.getValue());
	}

	@Override
	public void response(IWomen women) {
		System.out.println("----母亲向儿子请示----");
		System.out.println(women.getRequest());
		System.out.println("答复:同意");
	}

}
