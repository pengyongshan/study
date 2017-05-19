package com.tree.www.pattern.chains;

public class Father extends Handler {

	public Father() {
		super(TypeEnum.FATHER.getValue());
	}

	@Override
	public void response(IWomen women) {
		System.out.println("----女儿向父亲请示----");
		System.out.println(women.getRequest());
		System.out.println("答复:同意");
	}

}
