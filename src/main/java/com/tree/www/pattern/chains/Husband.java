package com.tree.www.pattern.chains;

public class Husband extends Handler {

	public Husband() {
		super(TypeEnum.HUSBAND.getValue());
	}

	@Override
	public void response(IWomen women) {
		System.out.println("----妻子向丈夫请示----");
		System.out.println(women.getRequest());
		System.out.println("答复:同意");
	}

}
